package sh.com.pe.ExpenseManagement.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import sh.com.pe.ExpenseManagement.exceptions.ExpenseManagementAppException;

/**
 *
 * @author shmen
 */
@Service
public class JwtTokenProvider {

    @Value("${app.jwt-secret}")
    private final String jwtSecret;

    @Value("${app.jwt-expiration-milliseconds}")
    private final long jwtExpirationInMs;

    public JwtTokenProvider() {
        this.jwtSecret = null;
        this.jwtExpirationInMs = 0;
    }

    public JwtTokenProvider(String jwtSecret, long jwtExpirationInMs) {
        this.jwtSecret = jwtSecret;
        this.jwtExpirationInMs = jwtExpirationInMs;
    }

    // Public methods
    public String obtainUsernameFromJwt(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .claim("roles", userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = obtainUsernameFromJwt(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    // Private methods
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(getSigninKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (SignatureException ex) {
            throw new ExpenseManagementAppException(HttpStatus.BAD_REQUEST, "Firma JWT no válida.");
        } catch (MalformedJwtException ex) {
            throw new ExpenseManagementAppException(HttpStatus.BAD_REQUEST, "Token JWT no válida.");
        } catch (ExpiredJwtException ex) {
            throw new ExpenseManagementAppException(HttpStatus.BAD_REQUEST, "Token JWT caducado.");
        } catch (UnsupportedJwtException ex) {
            throw new ExpenseManagementAppException(HttpStatus.BAD_REQUEST, "Token JWT no compatible.");
        } catch (IllegalArgumentException ex) {
            throw new ExpenseManagementAppException(HttpStatus.BAD_REQUEST, "La cadena Claims JWT está vacía.");
        }
    }

    private Key getSigninKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}

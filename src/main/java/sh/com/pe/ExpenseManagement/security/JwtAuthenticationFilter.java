package sh.com.pe.ExpenseManagement.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import sh.com.pe.ExpenseManagement.repository.TokenRepository;

/**
 *
 * @author shmen
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    private final CustomUserDetailsService customUserDetailsService;

    private final TokenRepository tokenRepository;

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider, CustomUserDetailsService customUserDetailsService, TokenRepository tokenRepository) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.customUserDetailsService = customUserDetailsService;
        this.tokenRepository = tokenRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String username;

        logger.info("Authorization Header: {}", authHeader);
        
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            logger.warn("Authorization Header not found or not start with \"Bearer\"");
            filterChain.doFilter(request, response);
            return;
        }

        logger.debug("Obtención del token y username");
        jwt = authHeader.substring(7);
        username = jwtTokenProvider.obtainUsernameFromJwt(jwt);
        logger.debug("JWT= {}, USERNAME= {}", jwt, username);

        logger.info("Iniciando verificación de existencia del username y si la autenticación es nula");
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
            logger.debug("USERDETAILS= {}", userDetails);

            boolean isTokenValid = tokenRepository.findByToken(jwt)
                    .map(t -> t.getExpired() != 1 && t.getRevoked() != 1)
                    .orElse(false);
            
            logger.info("Iniciando verificación del token actual si es válido");
            if (jwtTokenProvider.isTokenValid(jwt, userDetails) && isTokenValid) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
                logger.debug("AUTHTOKEN= {}", authToken);
            }
        }

        filterChain.doFilter(request, response);
    }
    
}

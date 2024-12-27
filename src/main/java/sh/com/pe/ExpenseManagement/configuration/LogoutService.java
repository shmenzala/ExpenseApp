package sh.com.pe.ExpenseManagement.configuration;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;
import sh.com.pe.ExpenseManagement.exceptions.ResourceNotFoundException;
import sh.com.pe.ExpenseManagement.model.Token;
import sh.com.pe.ExpenseManagement.repository.TokenRepository;

/**
 *
 * @author shmen
 */
@Service
public class LogoutService implements LogoutHandler {

    private final TokenRepository tokenRepository;

    public LogoutService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

        final String authHeader = request.getHeader("Authorization");
        final String jwt;

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }

        jwt = authHeader.substring(7);

        Token storedToken = tokenRepository.findByToken(jwt)
                .orElseThrow(() -> new ResourceNotFoundException("Token", "token", jwt));

        if (storedToken != null) {
            storedToken.setExpired(1);
            storedToken.setRevoked(1);
            clearDeviceIdCookie(response);

            tokenRepository.save(storedToken);
        }
    }

    private void clearDeviceIdCookie(HttpServletResponse response) {
        Cookie deviceIdCookie = new Cookie("deviceId", null);
        deviceIdCookie.setHttpOnly(true);
        deviceIdCookie.setSecure(true);
        deviceIdCookie.setMaxAge(0);
        deviceIdCookie.setPath("/");
        response.addCookie(deviceIdCookie);
    }

}

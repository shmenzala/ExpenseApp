package sh.com.pe.ExpenseManagement.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sh.com.pe.ExpenseManagement.dto.JwtAuthenticationDto;
import sh.com.pe.ExpenseManagement.dto.LoginDtoRequest;
import sh.com.pe.ExpenseManagement.dto.RegisterDtoRequest;
import sh.com.pe.ExpenseManagement.service.AuthenticationService;

/**
 *
 * @author shmen
 */
@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<JwtAuthenticationDto> registerUser(@Valid @RequestBody RegisterDtoRequest dto, HttpServletRequest request, HttpServletResponse response) {
        return ResponseEntity.ok(authenticationService.register(dto, request, response));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationDto> authenticateUser(@Valid @RequestBody LoginDtoRequest dto, HttpServletRequest request, HttpServletResponse response) {
        return ResponseEntity.ok(authenticationService.authenticate(dto, request, response));
    }

}

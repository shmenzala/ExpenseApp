package sh.com.pe.ExpenseManagement.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sh.com.pe.ExpenseManagement.dto.JwtAuthenticationDto;
import sh.com.pe.ExpenseManagement.dto.LoginDtoRequest;
import sh.com.pe.ExpenseManagement.dto.RegisterDtoRequest;

/**
 *
 * @author shmen
 */
public interface AuthenticationService {

    public JwtAuthenticationDto register(RegisterDtoRequest dto, HttpServletRequest request, HttpServletResponse response);

    public JwtAuthenticationDto authenticate(LoginDtoRequest dto, HttpServletRequest request, HttpServletResponse response);

}

package sh.com.pe.ExpenseManagement.service;

import sh.com.pe.ExpenseManagement.dto.JwtAuthenticationDto;
import sh.com.pe.ExpenseManagement.dto.LoginDtoRequest;
import sh.com.pe.ExpenseManagement.dto.RegisterDtoRequest;

/**
 *
 * @author shmen
 */
public interface AuthenticationService {

    public JwtAuthenticationDto register(RegisterDtoRequest dto);

    public JwtAuthenticationDto authenticate(LoginDtoRequest dto);

}

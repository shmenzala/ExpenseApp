package sh.com.pe.ExpenseManagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author shmen
 */
public class RegisterDtoRequest {

    @NotBlank(message = "El campo email no debe estar vacío")
    @Email(message = "El campo email tiene una dirección de correo electrónico con formato INCORRECTO", regexp = "(?i)^(([^<>()[\\\\]\\.,;:\\s@\\\\\"]+(\\.[^<>()[\\\\]\\.,;:\\s@\\\\\"]+)*)|(\\\\\".+\\\\\"))@(([^<>()[\\\\]\\.,;:\\s@\\\\\"]+\\.)+[^<>()[\\\\]\\.,;:\\s@\\\\\"]{2,})$")
    private String email;

    @NotBlank(message = "El campo password no debe estar vacío")
    private String password;

    public RegisterDtoRequest() {
    }

    public RegisterDtoRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

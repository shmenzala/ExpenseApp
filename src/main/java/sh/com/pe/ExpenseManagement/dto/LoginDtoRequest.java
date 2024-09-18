package sh.com.pe.ExpenseManagement.dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author shmen
 */
public class LoginDtoRequest {

    @NotBlank(message = "El campo username no debe estar vacío")
    private String username;

    @NotBlank(message = "El campo password no debe estar vacío")
    private String password;

    public LoginDtoRequest() {
    }

    public LoginDtoRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

package sh.com.pe.ExpenseManagement.dto;

/**
 *
 * @author shmen
 */
public class JwtAuthenticationDto {

    private String tokenDeAcceso;
    private String tipoDeToken = "Bearer";

    public JwtAuthenticationDto() {
    }

    public JwtAuthenticationDto(String tokenDeAcceso) {
        this.tokenDeAcceso = tokenDeAcceso;
    }

    public String getTokenDeAcceso() {
        return tokenDeAcceso;
    }

    public void setTokenDeAcceso(String tokenDeAcceso) {
        this.tokenDeAcceso = tokenDeAcceso;
    }

    public String getTipoDeToken() {
        return tipoDeToken;
    }

    public void setTipoDeToken(String tipoDeToken) {
        this.tipoDeToken = tipoDeToken;
    }

}

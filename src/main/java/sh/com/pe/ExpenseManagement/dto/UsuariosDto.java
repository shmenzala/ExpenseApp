package sh.com.pe.ExpenseManagement.dto;

/**
 *
 * @author shmen
 */
public class UsuariosDto {

    private int id;
    private String username;
    private String email;
    private String password;
    private Personas_perfilDto personas_perfil;

    public UsuariosDto() {
    }

    public UsuariosDto(int id, String username, String email, String password, Personas_perfilDto personas_perfil) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.personas_perfil = personas_perfil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Personas_perfilDto getPersonas_perfil() {
        return personas_perfil;
    }

    public void setPersonas_perfil(Personas_perfilDto personas_perfil) {
        this.personas_perfil = personas_perfil;
    }

}

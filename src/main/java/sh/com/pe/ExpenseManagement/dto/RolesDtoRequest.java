package sh.com.pe.ExpenseManagement.dto;

/**
 *
 * @author shmen
 */
public class RolesDtoRequest {

    private String nombre;

    public RolesDtoRequest() {
    }

    public RolesDtoRequest(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

package sh.com.pe.ExpenseManagement.dto;

/**
 *
 * @author shmen
 */
public class RolesRequestDto {

    private String nombre;

    public RolesRequestDto() {
    }

    public RolesRequestDto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

package sh.com.pe.ExpenseManagement.dto;

/**
 *
 * @author shmen
 */
public class RolesDto {

    private int id;
    private String nombre;

    public RolesDto() {
    }

    public RolesDto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

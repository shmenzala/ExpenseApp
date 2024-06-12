package sh.com.pe.ExpenseManagement.dto;

/**
 *
 * @author shmen
 */
public class Categorias_gastoDto {

    private int id;
    private String nombre;

    public Categorias_gastoDto() {
    }

    public Categorias_gastoDto(int id, String nombre) {
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

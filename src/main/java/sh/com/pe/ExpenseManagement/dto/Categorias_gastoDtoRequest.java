package sh.com.pe.ExpenseManagement.dto;

/**
 *
 * @author shmen
 */
public class Categorias_gastoDtoRequest {

    private String nombre;

    public Categorias_gastoDtoRequest() {
    }

    public Categorias_gastoDtoRequest(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

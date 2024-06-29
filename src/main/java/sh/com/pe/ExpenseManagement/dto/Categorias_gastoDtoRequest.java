package sh.com.pe.ExpenseManagement.dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author shmen
 */
public class Categorias_gastoDtoRequest {

    @NotBlank(message = "El campo nombre no debe estar vacío")
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

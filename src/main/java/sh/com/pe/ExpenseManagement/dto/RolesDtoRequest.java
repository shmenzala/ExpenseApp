package sh.com.pe.ExpenseManagement.dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author shmen
 */
public class RolesDtoRequest {

    @NotBlank(message = "El campo nombre no debe estar vacío")
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

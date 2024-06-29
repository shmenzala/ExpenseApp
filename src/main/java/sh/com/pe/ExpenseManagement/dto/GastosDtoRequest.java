package sh.com.pe.ExpenseManagement.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author shmen
 */
public class GastosDtoRequest {

    @NotBlank(message = "El campo tipo_gasto no debe estar vacío")
    private String tipo_gasto;

    private Categorias_gastoDto categorias_gasto;

    @NotNull(message = "El campo gasto no debe estar vacío")
    @Min(value = 0, message = "El campo gasto debe ser mayor o igual a 0")
    private Double gasto;

    @NotNull(message = "El campo cantidad no debe estar vacío")
    @Min(value = 0, message = "El campo cantidad debe ser mayor o igual a 0")
    private Integer cantidad;

    public GastosDtoRequest() {
    }

    public GastosDtoRequest(String tipo_gasto, Categorias_gastoDto categorias_gasto, Double gasto, Integer cantidad) {
        this.tipo_gasto = tipo_gasto;
        this.categorias_gasto = categorias_gasto;
        this.gasto = gasto;
        this.cantidad = cantidad;
    }

    public String getTipo_gasto() {
        return tipo_gasto;
    }

    public void setTipo_gasto(String tipo_gasto) {
        this.tipo_gasto = tipo_gasto;
    }

    public Categorias_gastoDto getCategorias_gasto() {
        return categorias_gasto;
    }

    public void setCategorias_gasto(Categorias_gastoDto categorias_gasto) {
        this.categorias_gasto = categorias_gasto;
    }

    public Double getGasto() {
        return gasto;
    }

    public void setGasto(Double gasto) {
        this.gasto = gasto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}

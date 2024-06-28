package sh.com.pe.ExpenseManagement.dto;

/**
 *
 * @author shmen
 */
public class GastosDtoRequest {

    private String tipo_gasto;
    private Categorias_gastoDto categorias_gasto;
    private double gasto;
    private Integer cantidad;

    public GastosDtoRequest() {
    }

    public GastosDtoRequest(String tipo_gasto, Categorias_gastoDto categorias_gasto, double gasto, Integer cantidad) {
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

    public double getGasto() {
        return gasto;
    }

    public void setGasto(double gasto) {
        this.gasto = gasto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}

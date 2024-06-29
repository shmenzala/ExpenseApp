package sh.com.pe.ExpenseManagement.dto;

import java.time.LocalDate;

/**
 *
 * @author shmen
 */
public class GastosDto {

    private int id;
    private String tipo_gasto;
    private Categorias_gastoDto categorias_gasto;
    private Double gasto;
    private Integer cantidad;
    private double total;
    private LocalDate fecha;

    public GastosDto() {
    }

    public GastosDto(int id, String tipo_gasto, Categorias_gastoDto categorias_gasto, Double gasto, Integer cantidad, double total, LocalDate fecha) {
        this.id = id;
        this.tipo_gasto = tipo_gasto;
        this.categorias_gasto = categorias_gasto;
        this.gasto = gasto;
        this.cantidad = cantidad;
        this.total = total;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}

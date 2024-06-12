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
    private int gasto;
    private LocalDate fecha;

    public GastosDto() {
    }

    public GastosDto(int id, String tipo_gasto, Categorias_gastoDto categorias_gasto, int gasto, LocalDate fecha) {
        this.id = id;
        this.tipo_gasto = tipo_gasto;
        this.categorias_gasto = categorias_gasto;
        this.gasto = gasto;
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

    public int getGasto() {
        return gasto;
    }

    public void setGasto(int gasto) {
        this.gasto = gasto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    

}

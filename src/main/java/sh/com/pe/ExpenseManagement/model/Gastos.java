package sh.com.pe.ExpenseManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author shmen
 */
@Entity
@SequenceGenerator(name = "seq_generator_g", sequenceName = "GASTOS_SQC", initialValue = 1, allocationSize = 1)
@Table(name = "GASTOS")
public class Gastos implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "seq_generator_g", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "tipo_gasto", length = 100)
    private String tipo_gasto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorias_gasto")
    private Categorias_gasto categorias_gasto;

    @Column(name = "gasto")
    private double gasto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "total")
    private Double total;

    @Column(name = "fecha")
    private LocalDate fecha;

    public Gastos() {
    }

    public Gastos(int id, String tipo_gasto, Categorias_gasto categorias_gasto, double gasto, Integer cantidad, Double total, LocalDate fecha) {
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

    public Categorias_gasto getCategorias_gasto() {
        return categorias_gasto;
    }

    public void setCategorias_gasto(Categorias_gasto categorias_gasto) {
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}

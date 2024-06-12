package sh.com.pe.ExpenseManagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author shmen
 */
@Entity
@SequenceGenerator(name = "seq_generator_cg", sequenceName = "CATEGORIAS_GASTO_SQC", initialValue = 1, allocationSize = 1)
@Table(name = "CATEGORIAS_GASTO")
public class Categorias_gasto implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "seq_generator_cg", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @JsonBackReference
    @OneToMany(mappedBy = "categorias_gasto")
    private Set<Gastos> gastos = new HashSet<>();

    public Categorias_gasto() {
    }

    public Categorias_gasto(int id, String nombre) {
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

    public Set<Gastos> getGastos() {
        return gastos;
    }

    public void setGastos(Set<Gastos> gastos) {
        this.gastos = gastos;
    }

}

package sh.com.pe.ExpenseManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@SequenceGenerator(name = "seq_generator_r", sequenceName = "ROLES_SQC", initialValue = 1, allocationSize = 1)
@Table(name = "ROLES")
public class Roles implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "seq_generator_r", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<Usuarios> usuarios = new HashSet<>();

    public Roles() {
    }

    public Roles(int id, String nombre) {
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

    public Set<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }

}

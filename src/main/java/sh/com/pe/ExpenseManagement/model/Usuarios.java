package sh.com.pe.ExpenseManagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@SequenceGenerator(name = "seq_generator_u", sequenceName = "USUARIOS_SQC", initialValue = 1, allocationSize = 1)
@Table(name = "USUARIOS")
public class Usuarios implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "seq_generator_u", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "username", length = 20)
    private String username;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "password", length = 30)
    private String password;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "personas_perfil")
    private Personas_perfil personas_perfil;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USUARIOS_ROLES",
            joinColumns = @JoinColumn(name = "usuarios", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "roles", referencedColumnName = "id"))
    private Set<Roles> roles = new HashSet<>();

    @JsonBackReference
    @OneToMany(mappedBy = "usuarios")
    private Set<Gastos> gastos = new HashSet<>();

    public Usuarios() {
    }

    public Usuarios(int id, String username, String email, String password, Personas_perfil personas_perfil) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.personas_perfil = personas_perfil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Personas_perfil getPersonas_perfil() {
        return personas_perfil;
    }

    public void setPersonas_perfil(Personas_perfil personas_perfil) {
        this.personas_perfil = personas_perfil;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public Set<Gastos> getGastos() {
        return gastos;
    }

    public void setGastos(Set<Gastos> gastos) {
        this.gastos = gastos;
    }

}

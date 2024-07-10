package sh.com.pe.ExpenseManagement.dto;

import java.time.LocalDate;

/**
 *
 * @author shmen
 */
public class Personas_perfilDto {

    private int id;
    private String nombres;
    private String apellidos;
    private String genero;
    private LocalDate fecha_nacimiento;
    private String fotografia;

    public Personas_perfilDto() {
    }

    public Personas_perfilDto(int id, String nombres, String apellidos, String genero, LocalDate fecha_nacimiento, String fotografia) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.genero = genero;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fotografia = fotografia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

}

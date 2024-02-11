package uce.edu.pw_api_u3_p5_pa.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

public class EstudianteTO extends RepresentationModel<EstudianteTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String nombre;

    private String apellido;

    private String genero;

    private LocalDateTime fechaNacimiento;

    private String semestre;

    private Boolean afiliadoSeguro;

    private Boolean gratuidad;

    private String nivelEconomico;

    private String numTelefono;

    private String domicilio;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Boolean getAfiliadoSeguro() {
        return afiliadoSeguro;
    }

    public void setAfiliadoSeguro(Boolean afiliadoSeguro) {
        this.afiliadoSeguro = afiliadoSeguro;
    }

    public Boolean getGratuidad() {
        return gratuidad;
    }

    public void setGratuidad(Boolean gratuidad) {
        this.gratuidad = gratuidad;
    }

    public String getNivelEconomico() {
        return nivelEconomico;
    }

    public void setNivelEconomico(String nivelEconomico) {
        this.nivelEconomico = nivelEconomico;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

}

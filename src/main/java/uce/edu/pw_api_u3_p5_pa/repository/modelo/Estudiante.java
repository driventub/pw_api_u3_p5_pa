package uce.edu.pw_api_u3_p5_pa.repository.modelo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante {
    
    @Id
    @GeneratedValue(generator = "seq_estu", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_estu", sequenceName = "seq_estu", allocationSize = 1)
    @Column(name = "estu_id")
    private Integer id;

    @Column(name = "estu_nombre")
    private String nombre;

    @Column(name = "estu_apellido")
    private String apellido;

    @Column(name = "estu_genero")
    private String genero;

    @Column(name = "estu_fecha_nacimiento")
    private LocalDateTime fechaNacimiento;

    @Column(name = "estu_semestre")
    private String semestre;

    @Column(name = "estu_seguro")
    private Boolean afiliadoSeguro;

    @Column(name = "estu_gratuidad")
    private Boolean gratuidad;

    @Column(name = "estu_nivel_economico")
    private String nivelEconomico;

    @Column(name = "estu_telefono")
    private String numTelefono;
    
    @Column(name = "estu_domicilio")
    private String domicilio;



    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private List<Materia> materias;

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
    public List<Materia> getMaterias() {
        return materias;
    }
    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
    // Setter y Getters
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

    
}

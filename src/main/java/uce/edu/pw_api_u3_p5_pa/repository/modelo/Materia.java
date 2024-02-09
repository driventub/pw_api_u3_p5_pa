package uce.edu.pw_api_u3_p5_pa.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "materia")
public class Materia {

    @Id
    @GeneratedValue(generator = "seq_mate", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_mate", sequenceName = "seq_mate", allocationSize = 1)
    @Column(name = "mate_id")
    private Integer id;

    @Column(name = "mate_nombre")
    private String nombre;

    @Column(name = "mate_creditos")
    private Integer creditos;

    @ManyToOne
    @JoinColumn(name = "mate_estu_id")
    private Estudiante estudiante;

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

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

}

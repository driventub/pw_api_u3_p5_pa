package uce.edu.pw_api_u3_p5_pa.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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

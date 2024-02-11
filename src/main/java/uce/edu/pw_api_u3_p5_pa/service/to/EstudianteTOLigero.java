package uce.edu.pw_api_u3_p5_pa.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class EstudianteTOLigero  extends RepresentationModel<EstudianteTO> implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nombre, apellido;
    
    // set y get
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
    

}

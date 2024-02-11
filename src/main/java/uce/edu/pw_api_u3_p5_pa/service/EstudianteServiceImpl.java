package uce.edu.pw_api_u3_p5_pa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uce.edu.pw_api_u3_p5_pa.repository.IEstudianteRepo;
import uce.edu.pw_api_u3_p5_pa.repository.modelo.Estudiante;
import uce.edu.pw_api_u3_p5_pa.service.to.EstudianteTO;
import uce.edu.pw_api_u3_p5_pa.service.to.EstudianteTOLigero;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

    @Autowired
    private IEstudianteRepo repo;
    

    @Override
    public void insertar(Estudiante e) {
        this.repo.insertar(e);
        
    }

    @Override
    public void actualizar(Estudiante e) {
        
       this.repo.actualizar(e);
    }

    @Override
    public void actualizarParcial(String apellido, String nombre,Integer id) {
        
        this.repo.actualizarParcial(apellido, nombre, id);
    }

    @Override
    public void eliminar(Integer id) {
        
        this.repo.eliminar(id);
    }

    @Override
    public Estudiante seleccionar(Integer id) {
        
        return this.repo.seleccionar(id);
    }

    @Override
    public List<Estudiante> seleccionarTodos() {
        return this.repo.seleccionarTodos();
    }

    @Override
    public List<EstudianteTO> seleccionarTodosTO() {
        List<EstudianteTO> listaFinal = new ArrayList<>();
        List<Estudiante> lista = this.repo.seleccionarTodos();
        for (Estudiante estudiante : lista) {
            listaFinal.add(this.convertir(estudiante));
        }
        return listaFinal;


    }

    private EstudianteTO convertir(Estudiante e) {
        EstudianteTO estudianteTO = new EstudianteTO();
        estudianteTO.setApellido(e.getApellido());
        estudianteTO.setFechaNacimiento(e.getFechaNacimiento());
        estudianteTO.setGenero(e.getGenero());
        estudianteTO.setNombre(e.getNombre());
        estudianteTO.setAfiliadoSeguro(e.getAfiliadoSeguro());
        estudianteTO.setDomicilio(e.getDomicilio());
        estudianteTO.setGratuidad(e.getGratuidad());
        estudianteTO.setNivelEconomico(e.getNivelEconomico());
        estudianteTO.setNumTelefono(e.getNumTelefono());
        estudianteTO.setSemestre(e.getSemestre());
        estudianteTO.setId(e.getId());
        return estudianteTO;        
    }

    private EstudianteTOLigero convertirLigero(Estudiante e) {
        EstudianteTOLigero estudianteTO = new EstudianteTOLigero();
        estudianteTO.setApellido(e.getApellido());
        estudianteTO.setNombre(e.getNombre());
        estudianteTO.setId(e.getId());
        return estudianteTO;        
    }

    @Override
    public EstudianteTO buscarTO(Integer id) {
        // TODO Auto-generated method stub
        return this.convertir(this.repo.seleccionar(id));
    }

    @Override
    public EstudianteTOLigero buscarLigero(Integer id) {
        
        return this.convertirLigero(this.repo.seleccionar(id));
    }
    
}

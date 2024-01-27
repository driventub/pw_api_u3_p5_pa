package uce.edu.pw_api_u3_p5_pa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uce.edu.pw_api_u3_p5_pa.repository.IEstudianteRepo;
import uce.edu.pw_api_u3_p5_pa.repository.modelo.Estudiante;

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
    
}

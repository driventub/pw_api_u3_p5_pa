package uce.edu.pw_api_u3_p5_pa.service;

import java.util.List;

import uce.edu.pw_api_u3_p5_pa.repository.modelo.Estudiante;
import uce.edu.pw_api_u3_p5_pa.service.to.EstudianteTO;

public interface IEstudianteService {
  public void insertar(Estudiante e);

  public void actualizar(Estudiante e);

  public void actualizarParcial(String apellido, String nombre, Integer id);

  public void eliminar(Integer id);

  public Estudiante seleccionar(Integer id);
  public EstudianteTO buscarTO(Integer id);

  

  public List<Estudiante> seleccionarTodos(String genero);

  public List<EstudianteTO> seleccionarTodosTO();

}

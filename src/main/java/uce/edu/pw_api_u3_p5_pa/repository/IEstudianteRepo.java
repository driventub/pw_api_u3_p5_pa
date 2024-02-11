package uce.edu.pw_api_u3_p5_pa.repository;

import java.util.List;

import uce.edu.pw_api_u3_p5_pa.repository.modelo.Estudiante;

public interface IEstudianteRepo {
    public void insertar(Estudiante e);

    public void actualizar(Estudiante e);

    public void actualizarParcial(String apellido, String nombre, Integer id);

    public void eliminar(Integer id);

    public Estudiante seleccionar(Integer id);

    public List<Estudiante> seleccionarTodos();

}

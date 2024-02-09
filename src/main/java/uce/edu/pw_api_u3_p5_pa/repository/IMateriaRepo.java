package uce.edu.pw_api_u3_p5_pa.repository;

import java.util.List;

import uce.edu.pw_api_u3_p5_pa.repository.modelo.Materia;

public interface IMateriaRepo {
    public List<Materia> seleccionarPorIdEstudiante(Integer id);
}

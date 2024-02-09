package uce.edu.pw_api_u3_p5_pa.service;

import java.util.List;

import uce.edu.pw_api_u3_p5_pa.service.to.MateriaTO;

public interface IMateriaService {
    public List<MateriaTO> seleccionarPorIdEstudiante(Integer id) ;
}

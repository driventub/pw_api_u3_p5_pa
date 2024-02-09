package uce.edu.pw_api_u3_p5_pa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uce.edu.pw_api_u3_p5_pa.repository.IMateriaRepo;
import uce.edu.pw_api_u3_p5_pa.repository.modelo.Materia;
import uce.edu.pw_api_u3_p5_pa.service.to.MateriaTO;

@Service
public class MateriaServiceImpl implements IMateriaService{
    
    @Autowired
    private IMateriaRepo repo;

    @Override
    public List<MateriaTO> seleccionarPorIdEstudiante(Integer id) {
        List<MateriaTO> listaFinal = new ArrayList<>();
        List<Materia> lista = this.repo.seleccionarPorIdEstudiante(id);
        for (Materia Materia : lista) {
            listaFinal.add(this.convertir(Materia));
        }
        return listaFinal;
    }

    private MateriaTO convertir(Materia mat){
        MateriaTO to = new MateriaTO();
        to.setId(mat.getId());
        to.setCreditos(mat.getCreditos());
        to.setNombre(mat.getNombre());
        return to;
    }


}

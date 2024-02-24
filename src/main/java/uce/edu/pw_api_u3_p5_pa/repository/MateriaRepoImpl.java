package uce.edu.pw_api_u3_p5_pa.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import uce.edu.pw_api_u3_p5_pa.repository.modelo.Materia;

@Repository
@Transactional
public class MateriaRepoImpl implements IMateriaRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Materia> seleccionarPorIdEstudiante(Integer id) {
        
        TypedQuery<Materia> myQuery = this.em
                .createQuery("SELECT m FROM Materia m WHERE m.estudiante.id = :id", Materia.class)
                .setParameter("id", id);
        return myQuery.getResultList();
    }

}

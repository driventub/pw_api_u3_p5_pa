package uce.edu.pw_api_u3_p5_pa.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.pw_api_u3_p5_pa.repository.modelo.Estudiante;

@Repository
@Transactional
public class EstudianteRepoImpl implements IEstudianteRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insertar(Estudiante e) {
        this.em.persist(e);
    }

    @Override
    public void actualizar(Estudiante e) {
        this.em.merge(e);

    }

    @Override
    public void actualizarParcial(String apellido, String nombre, Integer id) {

        Query query = this.em
                .createQuery("UPDATE Estudiante e SET e.apellido = :apellido , e.nombre = :nombre WHERE e.id = :id")
                .setParameter("id", id)
                .setParameter("apellido", apellido)
                .setParameter("nombre", nombre);
        query.executeUpdate();
    }

    @Override
    public void eliminar(Integer id) {

        this.em.remove(this.seleccionar(id));
    }

    @Override
    public Estudiante seleccionar(Integer id) {
        return this.em.find(Estudiante.class, id);
    }

    @Override
    public List<Estudiante> seleccionarTodos() {

        TypedQuery<Estudiante> query = this.em
                .createQuery("SELECT a FROM Estudiante a ", Estudiante.class);

        return query.getResultList();
    }

}

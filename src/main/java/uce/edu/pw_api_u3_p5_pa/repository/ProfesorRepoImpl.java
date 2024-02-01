package uce.edu.pw_api_u3_p5_pa.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.pw_api_u3_p5_pa.repository.modelo.Profesor;

@Repository
@Transactional
public class ProfesorRepoImpl implements IProfesorRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insertar(Profesor p) {
        this.em.persist(p);
    }

    @Override
    public Profesor buscarPorId(Integer id) {
        return this.em.find(Profesor.class, id);
    }

    @Override
    public void actualizar(Profesor p) {
        this.em.merge(p);
    }

    @Override
    public void actualizarSalario(Integer id, BigDecimal salario) {
        Query query = this.em
                .createQuery("UPDATE Profesor p SET p.salario = :salario WHERE p.id = :id")
                .setParameter("id", id)
                .setParameter("salario", salario);
        query.executeUpdate();
    }

    @Override
    public void eliminar(Integer id) {
        this.em.remove(this.buscarPorId(id));
    }

    @Override
    public List<Profesor> buscarContrataciones(LocalDateTime fecha) {
        TypedQuery<Profesor> query = this.em
                .createQuery("SELECT a.nombre FROM Profesor a WHERE a.fechaContratacion > :fecha", Profesor.class)
                .setParameter("fecha", fecha);
        return query.getResultList();
    }

    @Override
    public Long contarSalario(BigDecimal salario) {
        TypedQuery<Long> query = this.em
                .createQuery("SELECT COUNT(a) FROM Profesor a WHERE a.salario >= :salario", Long.class)
                .setParameter("salario", salario);
        return query.getSingleResult();
    }

}

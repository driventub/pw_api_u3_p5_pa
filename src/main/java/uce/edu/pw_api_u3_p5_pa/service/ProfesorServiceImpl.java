package uce.edu.pw_api_u3_p5_pa.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uce.edu.pw_api_u3_p5_pa.repository.IProfesorRepo;
import uce.edu.pw_api_u3_p5_pa.repository.modelo.Profesor;

@Service
public class ProfesorServiceImpl implements IProfesorService {

    @Autowired
    private IProfesorRepo repo;

    @Override
    public void insertar(Profesor p) {

        this.repo.insertar(p);
    }

    @Override
    public Profesor buscarPorId(Integer id) {

        return this.repo.buscarPorId(id);
    }

    @Override
    public void actualizar(Profesor p) {

        this.repo.actualizar(p);
    }

    @Override
    public void actualizarSalario(Integer id, BigDecimal salario) {

        this.repo.actualizarSalario(id, salario);
    }

    @Override
    public void eliminar(Integer id) {

        this.repo.eliminar(id);
    }

    @Override
    public List<Profesor> buscarContrataciones(LocalDateTime fechaContratacion) {

        return this.repo.buscarContrataciones(fechaContratacion);
    }

    @Override
    public Long contarSalario(BigDecimal salario) {

        return this.repo.contarSalario(salario);
    }

}

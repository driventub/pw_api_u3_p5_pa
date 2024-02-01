package uce.edu.pw_api_u3_p5_pa.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import uce.edu.pw_api_u3_p5_pa.repository.modelo.Profesor;

public interface IProfesorRepo {
    public void insertar(Profesor p);

    public Profesor buscarPorId(Integer id);

    public void actualizar(Profesor p);

    public void actualizarSalario(Integer id, BigDecimal salario);

    public void eliminar(Integer id);

    public List<Profesor> buscarContrataciones(LocalDateTime fechaContratacion);

    public Long contarSalario(BigDecimal salario);
}

package uce.edu.pw_api_u3_p5_pa.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uce.edu.pw_api_u3_p5_pa.repository.modelo.Profesor;
import uce.edu.pw_api_u3_p5_pa.service.IProfesorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

    @Autowired
    private IProfesorService service;

    @GetMapping(path = "{id}")
    public Profesor consultarPorId(@PathVariable Integer id) {
        return this.service.buscarPorId(id);
    }

    
    @GetMapping()
    public List<Profesor> consultarPorContrataciones(@RequestParam LocalDateTime fecha) {
        return this.service.buscarContrataciones(fecha);
    }

    /**
     * Tuve que agregar una parte de /salarios dado que tendria conflicot con el 
     * metodo consultarPorContrataciones
     * @param valor
     * @return
     */
    @GetMapping(path = "/salarios/{valor}")
    public Long contarSalarios(@PathVariable BigDecimal valor) {
        return this.service.contarSalario(valor);
    }

    @PostMapping()
    public void ingresar(@RequestBody Profesor entity) {
        this.service.insertar(entity);

    }

    @PutMapping()
    public void actualizar(@RequestBody Profesor entity) {
        this.service.actualizar(entity);
    }

    @PatchMapping()
    public void actualizarSalario(@RequestParam Integer id, @RequestParam BigDecimal salario) {
        this.service.actualizarSalario(id, salario);
    }

    @DeleteMapping(path = "{id}")
    public void eliminar(@PathVariable Integer id) {
        this.service.eliminar(id);
    }

}

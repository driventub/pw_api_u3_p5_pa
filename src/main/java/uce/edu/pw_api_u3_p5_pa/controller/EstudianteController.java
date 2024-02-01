package uce.edu.pw_api_u3_p5_pa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import uce.edu.pw_api_u3_p5_pa.repository.modelo.Estudiante;
import uce.edu.pw_api_u3_p5_pa.service.IEstudianteService;



@RestController
@RequestMapping("/estudiantes")
@Slf4j
public class EstudianteController {

    @Autowired
    private IEstudianteService service;

    @GetMapping("{id}/{nuevo}")
    public Estudiante buscar(@PathVariable Integer id, @PathVariable String nuevo) {
        log.info(nuevo);
        return this.service.seleccionar(id);
    }

    @PostMapping()
    public void guardar(@RequestBody Estudiante entity) {

        this.service.insertar(entity);

    }

    @PutMapping()
    public void actualizar( @RequestBody Estudiante estu) {
        this.service.actualizar(estu);
    }

    @PatchMapping()
    public void actualizarParcial(@RequestBody Estudiante estu){
        this.service.actualizarParcial(estu.getApellido(), estu.getNombre(),estu.getId());
    }

    @DeleteMapping("{id}")
    public void eliminar(@PathVariable Integer id){
        this.service.eliminar(id);
    }

    @GetMapping()
    public List<Estudiante> consultarTodos(@RequestParam String genero, @RequestParam String algo) {
        log.warn(algo);
        return this.service.seleccionarTodos(genero);
    }
    
}

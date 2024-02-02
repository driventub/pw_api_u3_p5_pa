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

    /**
     * Se va a consultar con este formato
     * http://localhost:8080/API/v1.0/Matricula/{id}/{nuevo}
     * 
     * @param id:    va a ser el id del estudiante
     * @param nuevo: un valor de prueba
     * @return
     */
    @GetMapping(path = "{id}")
    public Estudiante consultarPorId(@PathVariable Integer id, @PathVariable(required = false) String nuevo) {
        log.info(nuevo);
        return this.service.seleccionar(id);
    }

    @PostMapping()
    public void guardar(@RequestBody Estudiante entity) {

        this.service.insertar(entity);

    }

    @PutMapping(path = "{id}")
    public void actualizar(@RequestBody Estudiante estu, @PathVariable Integer id) {
        estu.setId(id);
        this.service.actualizar(estu);
    }

    @PatchMapping("{id}")
    public void actualizarParcial(@RequestBody Estudiante estu, @PathVariable Integer id) {
        estu.setId(id);
        this.service.actualizarParcial(estu.getApellido(), estu.getNombre(), estu.getId());
    }

    @DeleteMapping(path = "{id}")
    public void eliminar(@PathVariable Integer id) {
        this.service.eliminar(id);
    }

    /**
     * Por ejemplo aqui no se pone nada en el path, dado que no pide argumentos
     * con @PathVariable
     * 
     * @param genero
     * @return
     */
    @GetMapping()
    public List<Estudiante> consultarTodos(@RequestParam(required = false, defaultValue = "M") String genero) {

        return this.service.seleccionarTodos(genero);
    }

}

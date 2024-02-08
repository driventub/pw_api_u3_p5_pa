package uce.edu.pw_api_u3_p5_pa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

import uce.edu.pw_api_u3_p5_pa.repository.modelo.Estudiante;
import uce.edu.pw_api_u3_p5_pa.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
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
    @GetMapping(path = "{id}", produces = "application/xml")
    public ResponseEntity<Estudiante> consultarPorId(@PathVariable Integer id) {

        // 240: recurso Estudiante enconntrado Satisfactoriamente!
        return ResponseEntity.status(HttpStatus.OK).body(this.service.seleccionar(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    public void guardar(@RequestBody Estudiante entity) {

        this.service.insertar(entity);

    }

    @PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizar(@RequestBody Estudiante estu, @PathVariable Integer id) {
        estu.setId(id);
        this.service.actualizar(estu);
    }

    @PatchMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
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
    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<List<Estudiante>> consultarTodos(
            @RequestParam(required = false, defaultValue = "F") String genero) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("mensaje_242", "Lista consultada de manera satisfactoria");
        headers.add("El genero es", genero);

        return new ResponseEntity<>(this.service.seleccionarTodos(genero), headers, 242);
    }

}

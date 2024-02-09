package uce.edu.pw_api_u3_p5_pa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import uce.edu.pw_api_u3_p5_pa.repository.modelo.Estudiante;
import uce.edu.pw_api_u3_p5_pa.service.IEstudianteService;
import uce.edu.pw_api_u3_p5_pa.service.IMateriaService;
import uce.edu.pw_api_u3_p5_pa.service.to.EstudianteTO;
import uce.edu.pw_api_u3_p5_pa.service.to.MateriaTO;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private IEstudianteService estuService;

    @Autowired
    private IMateriaService materiaService;

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
        return ResponseEntity.status(HttpStatus.OK).body(this.estuService.seleccionar(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    public void guardar(@RequestBody Estudiante entity) {

        this.estuService.insertar(entity);

    }

    @PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizar(@RequestBody Estudiante estu, @PathVariable Integer id) {
        estu.setId(id);
        this.estuService.actualizar(estu);
    }

    @PatchMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarParcial(@RequestBody Estudiante estu, @PathVariable Integer id) {
        estu.setId(id);
        this.estuService.actualizarParcial(estu.getApellido(), estu.getNombre(), estu.getId());
    }

    @DeleteMapping(path = "{id}")
    public void eliminar(@PathVariable Integer id) {
        this.estuService.eliminar(id);
    }

    // @GetMapping(path = "/tmp", produces = MediaType.APPLICATION_XML_VALUE)
    // public ResponseEntity<List<Estudiante>> consultarTodos(
    //         @RequestParam(required = false, defaultValue = "F") String genero) {

    //     HttpHeaders headers = new HttpHeaders();
    //     headers.add("mensaje_242", "Lista consultada de manera satisfactoria");
    //     headers.add("El genero es", genero);

    //     return new ResponseEntity<>(this.estuService.seleccionarTodos(genero), headers, 242);
    // }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EstudianteTO>> consultarTodosHateoas() {
        List<EstudianteTO> lista = this.estuService.seleccionarTodosTO();

        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/{id}/materias")
    public ResponseEntity<List<MateriaTO>> seleccionarPorIdEstudiante( @PathVariable Integer id) {
        return ResponseEntity.status(200).body(this.materiaService.seleccionarPorIdEstudiante(id));
    }

}

package uce.edu.pw_api_u3_p5_pa.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
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
  
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
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
    
    
    // @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<List<EstudianteTO>> consultarTodosHateoas() {
    //     List<EstudianteTO> lista = this.estuService.seleccionarTodosTO();

    //     for (EstudianteTO estudianteTO : lista) {
    //         Link link = linkTo(methodOn(EstudianteController.class).consultarLigero(estudianteTO.getId())).withRel("Estudiante Ligero: ");
    //         estudianteTO.add(link);
    //     }

    //     return ResponseEntity.status(HttpStatus.OK).body(lista);
    // }


    // @GetMapping(path = "/parcial/{id}", produces = "application/json")
    // public ResponseEntity<EstudianteTOLigero> consultarLigero(@PathVariable Integer id) {
    //     EstudianteTOLigero estudianteTO = this.estuService.buscarLigero(id);
    //     Link link = linkTo(methodOn(EstudianteController.class).consultarPorId(estudianteTO.getId())).withRel("Estudiante Completo: ");
    //     estudianteTO.add(link);

       
    //     // 240: recurso Estudiante enconntrado Satisfactoriamente!
    //     return ResponseEntity.status(HttpStatus.OK).body(estudianteTO);
    // }

    // @GetMapping(path = "/{id}", produces = "application/json")
    // public ResponseEntity<EstudianteTO> consultarPorId(@PathVariable Integer id) {
    //     EstudianteTO estudianteTO = this.estuService.buscarTO(id);
    //     Link link = linkTo(methodOn(EstudianteController.class).seleccionarMateriasPorIdEstudiante(estudianteTO.getId())).withRel("Lista de Materias: ");
    //     estudianteTO.add(link);

       
    //     // 240: recurso Estudiante enconntrado Satisfactoriamente!
    //     return ResponseEntity.status(HttpStatus.OK).body(estudianteTO);
    // }


    @GetMapping("/{id}/materias")
    public ResponseEntity<List<MateriaTO>> seleccionarMateriasPorIdEstudiante( @PathVariable Integer id) {
        return ResponseEntity.status(200).body(this.materiaService.seleccionarPorIdEstudiante(id));
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EstudianteTO>> consultarTodos() {
        List<EstudianteTO> lista = this.estuService.seleccionarTodosTO();

        for (EstudianteTO estudianteTO : lista) {
            @SuppressWarnings("null")
            Link link = linkTo(methodOn(EstudianteController.class).seleccionarMateriasPorIdEstudiante(estudianteTO.getId())).withRel("Estudiante Ligero: ");
            estudianteTO.add(link);
        }

        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }


    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<EstudianteTO> consultarPorId(@PathVariable Integer id) {
        EstudianteTO estudianteTO = this.estuService.buscarTO(id);
        @SuppressWarnings("null")
        Link link = linkTo(methodOn(EstudianteController.class).seleccionarMateriasPorIdEstudiante(estudianteTO.getId())).withRel("Lista de Materias: ");
        estudianteTO.add(link);

       
        // 240: recurso Estudiante enconntrado Satisfactoriamente!
        return ResponseEntity.status(HttpStatus.OK).body(estudianteTO);
    }
}

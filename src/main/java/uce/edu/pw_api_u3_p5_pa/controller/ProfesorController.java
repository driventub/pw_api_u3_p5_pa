package uce.edu.pw_api_u3_p5_pa.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

import uce.edu.pw_api_u3_p5_pa.repository.modelo.Profesor;
import uce.edu.pw_api_u3_p5_pa.service.IProfesorService;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

    @Autowired
    private IProfesorService service;

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Profesor> consultarPorId(@PathVariable Integer id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("El id es", Integer.toString(id));

        return  new ResponseEntity<>(this.service.buscarPorId(id), headers, 252);
    }

    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Profesor>> consultarPorContrataciones(@RequestParam LocalDateTime fecha) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("mensaje_252", "Lista consultada de manera satisfactoria");
        

        return new ResponseEntity<>(this.service.buscarContrataciones(fecha), headers, 252);
    }

    /**
     * Tuve que agregar una parte de /salarios dado que tendria conflicot con el 
     * metodo consultarPorContrataciones
     * @param valor
     * @return
     */
    @GetMapping(path = "/salarios/{valor}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> contarSalarios(@PathVariable BigDecimal valor) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("mensaje_252", "Salario contado de manera satisfactoria");
        headers.add("El genero es", valor.toString());

        return new ResponseEntity<>(this.service.contarSalario(valor), headers, 252);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<String> ingresar(@RequestBody Profesor entity) {
        try {
            this.service.insertar(entity);
            return ResponseEntity.ok("Profesor insertado correctamente"); // 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al insertar al Profesor: " + e.getMessage()); // 500 Internal Server Error
        }

    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> actualizar(@RequestBody Profesor entity) {
        try {
            this.service.actualizar(entity);
            return ResponseEntity.ok("Profesor actualizado correctamente"); // 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                    .body("Metodo no valido: " + e.getMessage()); // 500 Internal Server Error
        }
    }

    @PatchMapping()
    public ResponseEntity<String> actualizarSalario(@RequestParam Integer id, @RequestParam BigDecimal salario) {
        
        try {
            this.service.actualizarSalario(id, salario);
            return ResponseEntity.ok("Salario actualizado correctamente"); // 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el Profesor: " + e.getMessage()); // 500 Internal Server Error
        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        try {
            this.service.eliminar(id);
            return ResponseEntity.ok("Profesor correctamente eliminado"); // 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el Profesor: " + e.getMessage()); // 500 Internal Server Error
        }
    }

}

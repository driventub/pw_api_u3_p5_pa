package uce.edu.pw_api_u3_p5_pa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uce.edu.pw_api_u3_p5_pa.repository.modelo.Estudiante;
import uce.edu.pw_api_u3_p5_pa.service.IEstudianteService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(name = "estudiantes")
public class EstudianteController {

    @Autowired
    private IEstudianteService service;

    @GetMapping("{id}")
    public Estudiante buscar(@PathVariable Integer id) {
        return this.service.seleccionar(id);
    }

    @PostMapping()
    public void ingresar(@RequestBody Estudiante entity) {

        this.ingresar(entity);

    }

    @PutMapping("{id}")
    public void actualizar(@PathVariable Integer id, @RequestBody Estudiante estu) {
    
        this.actualizar(id, estu);
    }

    @DeleteMapping("id")
    public void eliminar(@PathVariable Integer id){
        this.eliminar(id);
    }

}

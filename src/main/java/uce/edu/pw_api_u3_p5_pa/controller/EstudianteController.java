package uce.edu.pw_api_u3_p5_pa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uce.edu.pw_api_u3_p5_pa.repository.modelo.Estudiante;
import uce.edu.pw_api_u3_p5_pa.service.IEstudianteService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private IEstudianteService service;

    @GetMapping("{id}")
    public Estudiante buscar(@PathVariable Integer id) {
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
    public void actualizarParcial(String apellido, String nombre,Integer id){
        this.service.actualizarParcial(apellido, nombre, id);
    }

    @DeleteMapping("{id}")
    public void eliminar(@PathVariable Integer id){
        this.service.eliminar(id);
    }

}

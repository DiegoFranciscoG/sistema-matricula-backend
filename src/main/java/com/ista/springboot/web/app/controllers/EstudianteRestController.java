package com.ista.springboot.web.app.controllers;

import com.ista.springboot.web.app.entity.Estudiante;
import com.ista.springboot.web.app.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EstudianteRestController {

    @Autowired
    private IEstudianteService estudianteService;

    @GetMapping("/estudiantes")
    public List<Estudiante> index() {
        return estudianteService.findAll();
    }

    @GetMapping("/estudiantes/{id}")
    public Estudiante show(@PathVariable Integer id) {
        return estudianteService.findById(id);
    }

    @GetMapping("/estudiantes/cedula/{cedula}")
    public Estudiante showByCedula(@PathVariable String cedula) {
        return estudianteService.findByCedula(cedula);
    }

    @PostMapping("/estudiantes")
    @ResponseStatus(HttpStatus.CREATED)
    public Estudiante create(@RequestBody Estudiante estudiante) {
        return estudianteService.save(estudiante);
    }

    @PutMapping("/estudiantes/{id}")
    public Estudiante update(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
        Estudiante estudianteActual = estudianteService.findById(id);
        
        estudianteActual.setCedula(estudiante.getCedula());
        estudianteActual.setNombres(estudiante.getNombres());
        estudianteActual.setApellidos(estudiante.getApellidos());
        estudianteActual.setFechaNacimiento(estudiante.getFechaNacimiento());
        estudianteActual.setDireccion(estudiante.getDireccion());
        estudianteActual.setTelefono(estudiante.getTelefono());
        estudianteActual.setEmail(estudiante.getEmail());
        estudianteActual.setEstado(estudiante.getEstado());
        
        return estudianteService.save(estudianteActual);
    }

    @DeleteMapping("/estudiantes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        estudianteService.delete(id);
    }
}
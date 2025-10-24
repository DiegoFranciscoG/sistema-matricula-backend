package com.ista.springboot.web.app.controllers;

import com.ista.springboot.web.app.entity.Estudiante;
import com.ista.springboot.web.app.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
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
    public ResponseEntity<Estudiante> show(@PathVariable Integer id) {
        Estudiante estudiante = estudianteService.findById(id);
        if (estudiante == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estudiante);
    }

    @GetMapping("/estudiantes/cedula/{cedula}")
    public ResponseEntity<Estudiante> showByCedula(@PathVariable String cedula) {
        Estudiante estudiante = estudianteService.findByCedula(cedula);
        if (estudiante == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estudiante);
    }

    @PostMapping("/estudiantes")
    public ResponseEntity<Estudiante> create(@RequestBody Estudiante estudiante) {
        // IMPORTANTE: No enviar idEstudiante en el JSON
        estudiante.setIdEstudiante(null);
        Estudiante nuevoEstudiante = estudianteService.save(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEstudiante);
    }

    @PutMapping("/estudiantes/{id}")
    public ResponseEntity<Estudiante> update(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
        Estudiante estudianteActual = estudianteService.findById(id);
        if (estudianteActual == null) {
            return ResponseEntity.notFound().build();
        }
        
        estudianteActual.setCedula(estudiante.getCedula());
        estudianteActual.setNombres(estudiante.getNombres());
        estudianteActual.setApellidos(estudiante.getApellidos());
        estudianteActual.setFechaNacimiento(estudiante.getFechaNacimiento());
        estudianteActual.setDireccion(estudiante.getDireccion());
        estudianteActual.setTelefono(estudiante.getTelefono());
        estudianteActual.setEmail(estudiante.getEmail());
        estudianteActual.setEstado(estudiante.getEstado());
        
        return ResponseEntity.ok(estudianteService.save(estudianteActual));
    }

    @DeleteMapping("/estudiantes/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Estudiante estudiante = estudianteService.findById(id);
        if (estudiante == null) {
            return ResponseEntity.notFound().build();
        }
        estudianteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
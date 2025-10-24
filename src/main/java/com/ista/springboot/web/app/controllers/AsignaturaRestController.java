package com.ista.springboot.web.app.controllers;

import com.ista.springboot.web.app.entity.Asignatura;
import com.ista.springboot.web.app.service.IAsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AsignaturaRestController {

    @Autowired
    private IAsignaturaService asignaturaService;

    @GetMapping("/asignaturas")
    public List<Asignatura> index() {
        return asignaturaService.findAll();
    }

    @GetMapping("/asignaturas/{id}")
    public ResponseEntity<Asignatura> show(@PathVariable Integer id) {
        Asignatura asignatura = asignaturaService.findById(id);
        if (asignatura == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(asignatura);
    }

    @GetMapping("/asignaturas/nivel/{nivelId}")
    public List<Asignatura> findByNivel(@PathVariable Integer nivelId) {
        return asignaturaService.findByNivelId(nivelId);
    }

    @PostMapping("/asignaturas")
    public ResponseEntity<Asignatura> create(@RequestBody Asignatura asignatura) {
        asignatura.setIdAsignatura(null);
        Asignatura nuevaAsignatura = asignaturaService.save(asignatura);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaAsignatura);
    }

    @PutMapping("/asignaturas/{id}")
    public ResponseEntity<Asignatura> update(@RequestBody Asignatura asignatura, @PathVariable Integer id) {
        Asignatura asignaturaActual = asignaturaService.findById(id);
        if (asignaturaActual == null) {
            return ResponseEntity.notFound().build();
        }
        
        asignaturaActual.setCodigo(asignatura.getCodigo());
        asignaturaActual.setNombre(asignatura.getNombre());
        asignaturaActual.setDescripcion(asignatura.getDescripcion());
        asignaturaActual.setNivel(asignatura.getNivel());
        
        return ResponseEntity.ok(asignaturaService.save(asignaturaActual));
    }

    @DeleteMapping("/asignaturas/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Asignatura asignatura = asignaturaService.findById(id);
        if (asignatura == null) {
            return ResponseEntity.notFound().build();
        }
        asignaturaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
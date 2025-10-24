package com.ista.springboot.web.app.controllers;

import com.ista.springboot.web.app.entity.Nivel;
import com.ista.springboot.web.app.service.INivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class NivelRestController {

    @Autowired
    private INivelService nivelService;

    @GetMapping("/niveles")
    public List<Nivel> index() {
        return nivelService.findAll();
    }

    @GetMapping("/niveles/{id}")
    public ResponseEntity<Nivel> show(@PathVariable Integer id) {
        Nivel nivel = nivelService.findById(id);
        if (nivel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(nivel);
    }

    @PostMapping("/niveles")
    public ResponseEntity<Nivel> create(@RequestBody Nivel nivel) {
        nivel.setIdNivel(null);
        Nivel nuevoNivel = nivelService.save(nivel);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoNivel);
    }

    @PutMapping("/niveles/{id}")
    public ResponseEntity<Nivel> update(@RequestBody Nivel nivel, @PathVariable Integer id) {
        Nivel nivelActual = nivelService.findById(id);
        if (nivelActual == null) {
            return ResponseEntity.notFound().build();
        }
        
        nivelActual.setNombre(nivel.getNombre());
        nivelActual.setDescripcion(nivel.getDescripcion());
        
        return ResponseEntity.ok(nivelService.save(nivelActual));
    }

    @DeleteMapping("/niveles/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Nivel nivel = nivelService.findById(id);
        if (nivel == null) {
            return ResponseEntity.notFound().build();
        }
        nivelService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
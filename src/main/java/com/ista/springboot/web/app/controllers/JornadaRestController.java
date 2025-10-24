package com.ista.springboot.web.app.controllers;

import com.ista.springboot.web.app.entity.Jornada;
import com.ista.springboot.web.app.service.IJornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class JornadaRestController {

    @Autowired
    private IJornadaService jornadaService;

    @GetMapping("/jornadas")
    public List<Jornada> index() {
        return jornadaService.findAll();
    }

    @GetMapping("/jornadas/{id}")
    public ResponseEntity<Jornada> show(@PathVariable Integer id) {
        Jornada jornada = jornadaService.findById(id);
        if (jornada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(jornada);
    }

    @PostMapping("/jornadas")
    public ResponseEntity<Jornada> create(@RequestBody Jornada jornada) {
        jornada.setIdJornada(null);
        Jornada nuevaJornada = jornadaService.save(jornada);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaJornada);
    }

    @PutMapping("/jornadas/{id}")
    public ResponseEntity<Jornada> update(@RequestBody Jornada jornada, @PathVariable Integer id) {
        Jornada jornadaActual = jornadaService.findById(id);
        if (jornadaActual == null) {
            return ResponseEntity.notFound().build();
        }
        
        jornadaActual.setNombre(jornada.getNombre());
        
        return ResponseEntity.ok(jornadaService.save(jornadaActual));
    }

    @DeleteMapping("/jornadas/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Jornada jornada = jornadaService.findById(id);
        if (jornada == null) {
            return ResponseEntity.notFound().build();
        }
        jornadaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

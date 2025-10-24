package com.ista.springboot.web.app.controllers;

import com.ista.springboot.web.app.entity.Paralelo;
import com.ista.springboot.web.app.service.IParaleloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ParaleloRestController {

    @Autowired
    private IParaleloService paraleloService;

    @GetMapping("/paralelos")
    public List<Paralelo> index() {
        return paraleloService.findAll();
    }

    @GetMapping("/paralelos/{id}")
    public ResponseEntity<Paralelo> show(@PathVariable Integer id) {
        Paralelo paralelo = paraleloService.findById(id);
        if (paralelo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paralelo);
    }

    @GetMapping("/paralelos/jornada/{jornadaId}")
    public List<Paralelo> findByJornada(@PathVariable Integer jornadaId) {
        return paraleloService.findByJornadaId(jornadaId);
    }

    @PostMapping("/paralelos")
    public ResponseEntity<Paralelo> create(@RequestBody Paralelo paralelo) {
        paralelo.setIdParalelo(null);
        Paralelo nuevoParalelo = paraleloService.save(paralelo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoParalelo);
    }

    @PutMapping("/paralelos/{id}")
    public ResponseEntity<Paralelo> update(@RequestBody Paralelo paralelo, @PathVariable Integer id) {
        Paralelo paraleloActual = paraleloService.findById(id);
        if (paraleloActual == null) {
            return ResponseEntity.notFound().build();
        }
        
        paraleloActual.setNombre(paralelo.getNombre());
        paraleloActual.setJornada(paralelo.getJornada());
        
        return ResponseEntity.ok(paraleloService.save(paraleloActual));
    }

    @DeleteMapping("/paralelos/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Paralelo paralelo = paraleloService.findById(id);
        if (paralelo == null) {
            return ResponseEntity.notFound().build();
        }
        paraleloService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
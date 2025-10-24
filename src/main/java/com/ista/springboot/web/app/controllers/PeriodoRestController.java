package com.ista.springboot.web.app.controllers;

import com.ista.springboot.web.app.entity.Periodo;
import com.ista.springboot.web.app.service.IPeriodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PeriodoRestController {

    @Autowired
    private IPeriodoService periodoService;

    @GetMapping("/periodos")
    public List<Periodo> index() {
        return periodoService.findAll();
    }

    @GetMapping("/periodos/{id}")
    public ResponseEntity<Periodo> show(@PathVariable Integer id) {
        Periodo periodo = periodoService.findById(id);
        if (periodo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(periodo);
    }

    @PostMapping("/periodos")
    public ResponseEntity<Periodo> create(@RequestBody Periodo periodo) {
        periodo.setIdPeriodo(null);
        Periodo nuevoPeriodo = periodoService.save(periodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPeriodo);
    }

    @PutMapping("/periodos/{id}")
    public ResponseEntity<Periodo> update(@RequestBody Periodo periodo, @PathVariable Integer id) {
        Periodo periodoActual = periodoService.findById(id);
        if (periodoActual == null) {
            return ResponseEntity.notFound().build();
        }
        
        periodoActual.setNombre(periodo.getNombre());
        periodoActual.setFechaInicio(periodo.getFechaInicio());
        periodoActual.setFechaFin(periodo.getFechaFin());
        periodoActual.setEstado(periodo.getEstado());
        
        return ResponseEntity.ok(periodoService.save(periodoActual));
    }

    @DeleteMapping("/periodos/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Periodo periodo = periodoService.findById(id);
        if (periodo == null) {
            return ResponseEntity.notFound().build();
        }
        periodoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

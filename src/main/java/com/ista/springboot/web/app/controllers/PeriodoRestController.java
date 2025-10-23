package com.ista.springboot.web.app.controllers;

import com.ista.springboot.web.app.entity.Periodo;
import com.ista.springboot.web.app.service.IPeriodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Periodo show(@PathVariable Integer id) {
        return periodoService.findById(id);
    }

    @PostMapping("/periodos")
    @ResponseStatus(HttpStatus.CREATED)
    public Periodo create(@RequestBody Periodo periodo) {
        return periodoService.save(periodo);
    }

    @PutMapping("/periodos/{id}")
    public Periodo update(@RequestBody Periodo periodo, @PathVariable Integer id) {
        Periodo periodoActual = periodoService.findById(id);
        
        periodoActual.setNombre(periodo.getNombre());
        periodoActual.setFechaInicio(periodo.getFechaInicio());
        periodoActual.setFechaFin(periodo.getFechaFin());
        periodoActual.setEstado(periodo.getEstado());
        
        return periodoService.save(periodoActual);
    }

    @DeleteMapping("/periodos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        periodoService.delete(id);
    }
}
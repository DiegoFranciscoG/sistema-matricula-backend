package com.ista.springboot.web.app.controllers;

import com.ista.springboot.web.app.entity.Paralelo;
import com.ista.springboot.web.app.service.IParaleloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Paralelo show(@PathVariable Integer id) {
        return paraleloService.findById(id);
    }

    @GetMapping("/paralelos/jornada/{jornadaId}")
    public List<Paralelo> findByJornada(@PathVariable Integer jornadaId) {
        return paraleloService.findByJornadaId(jornadaId);
    }

    @PostMapping("/paralelos")
    @ResponseStatus(HttpStatus.CREATED)
    public Paralelo create(@RequestBody Paralelo paralelo) {
        return paraleloService.save(paralelo);
    }

    @PutMapping("/paralelos/{id}")
    public Paralelo update(@RequestBody Paralelo paralelo, @PathVariable Integer id) {
        Paralelo paraleloActual = paraleloService.findById(id);
        
        paraleloActual.setNombre(paralelo.getNombre());
        paraleloActual.setJornada(paralelo.getJornada());
        
        return paraleloService.save(paraleloActual);
    }

    @DeleteMapping("/paralelos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        paraleloService.delete(id);
    }
}
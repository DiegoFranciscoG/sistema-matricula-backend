package com.ista.springboot.web.app.controllers;

import com.ista.springboot.web.app.entity.Nivel;
import com.ista.springboot.web.app.service.INivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Nivel show(@PathVariable Integer id) {
        return nivelService.findById(id);
    }

    @PostMapping("/niveles")
    @ResponseStatus(HttpStatus.CREATED)
    public Nivel create(@RequestBody Nivel nivel) {
        return nivelService.save(nivel);
    }

    @PutMapping("/niveles/{id}")
    public Nivel update(@RequestBody Nivel nivel, @PathVariable Integer id) {
        Nivel nivelActual = nivelService.findById(id);
        
        nivelActual.setNombre(nivel.getNombre());
        nivelActual.setDescripcion(nivel.getDescripcion());
        
        return nivelService.save(nivelActual);
    }

    @DeleteMapping("/niveles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        nivelService.delete(id);
    }
}
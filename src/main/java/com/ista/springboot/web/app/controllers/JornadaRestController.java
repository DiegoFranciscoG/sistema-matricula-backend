package com.ista.springboot.web.app.controllers;

import com.ista.springboot.web.app.entity.Jornada;
import com.ista.springboot.web.app.service.IJornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Jornada show(@PathVariable Integer id) {
        return jornadaService.findById(id);
    }

    @PostMapping("/jornadas")
    @ResponseStatus(HttpStatus.CREATED)
    public Jornada create(@RequestBody Jornada jornada) {
        return jornadaService.save(jornada);
    }

    @PutMapping("/jornadas/{id}")
    public Jornada update(@RequestBody Jornada jornada, @PathVariable Integer id) {
        Jornada jornadaActual = jornadaService.findById(id);
        
        jornadaActual.setNombre(jornada.getNombre());
        
        return jornadaService.save(jornadaActual);
    }

    @DeleteMapping("/jornadas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        jornadaService.delete(id);
    }
}
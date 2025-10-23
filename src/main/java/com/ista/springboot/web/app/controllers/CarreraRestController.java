package com.ista.springboot.web.app.controllers;

import com.ista.springboot.web.app.entity.Carrera;
import com.ista.springboot.web.app.service.ICarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarreraRestController {

    @Autowired
    private ICarreraService carreraService;

    @GetMapping("/carreras")
    public List<Carrera> index() {
        return carreraService.findAll();
    }

    @GetMapping("/carreras/{id}")
    public Carrera show(@PathVariable Integer id) {
        return carreraService.findById(id);
    }

    @PostMapping("/carreras")
    @ResponseStatus(HttpStatus.CREATED)
    public Carrera create(@RequestBody Carrera carrera) {
        return carreraService.save(carrera);
    }

    @PutMapping("/carreras/{id}")
    public Carrera update(@RequestBody Carrera carrera, @PathVariable Integer id) {
        Carrera carreraActual = carreraService.findById(id);
        
        carreraActual.setNombreCarrera(carrera.getNombreCarrera());
        carreraActual.setDuracionPeriodos(carrera.getDuracionPeriodos());
        
        return carreraService.save(carreraActual);
    }

    @DeleteMapping("/carreras/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        carreraService.delete(id);
    }
}
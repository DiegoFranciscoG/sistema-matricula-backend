package com.ista.springboot.web.app.controllers;

import com.ista.springboot.web.app.entity.Institucion;
import com.ista.springboot.web.app.service.IInstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstitucionRestController {

    @Autowired
    private IInstitucionService institucionService;

    @GetMapping("/instituciones")
    public List<Institucion> index() {
        return institucionService.findAll();
    }

    @GetMapping("/instituciones/{id}")
    public Institucion show(@PathVariable Integer id) {
        return institucionService.findById(id);
    }

    @PostMapping("/instituciones")
    @ResponseStatus(HttpStatus.CREATED)
    public Institucion create(@RequestBody Institucion institucion) {
        return institucionService.save(institucion);
    }

    @PutMapping("/instituciones/{id}")
    public Institucion update(@RequestBody Institucion institucion, @PathVariable Integer id) {
        Institucion institucionActual = institucionService.findById(id);
        
        institucionActual.setNombre(institucion.getNombre());
        institucionActual.setTipoEducativo(institucion.getTipoEducativo());
        
        return institucionService.save(institucionActual);
    }

    @DeleteMapping("/instituciones/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        institucionService.delete(id);
    }
}
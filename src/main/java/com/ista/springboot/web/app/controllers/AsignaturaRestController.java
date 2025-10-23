package com.ista.springboot.web.app.controllers;

import com.ista.springboot.web.app.entity.Asignatura;
import com.ista.springboot.web.app.service.IAsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AsignaturaRestController {

    @Autowired
    private IAsignaturaService asignaturaService;

    @GetMapping("/asignaturas")
    public List<Asignatura> index() {
        return asignaturaService.findAll();
    }

    @GetMapping("/asignaturas/{id}")
    public Asignatura show(@PathVariable Integer id) {
        return asignaturaService.findById(id);
    }

    @GetMapping("/asignaturas/nivel/{nivelId}")
    public List<Asignatura> findByNivel(@PathVariable Integer nivelId) {
        return asignaturaService.findByNivelId(nivelId);
    }

    @PostMapping("/asignaturas")
    @ResponseStatus(HttpStatus.CREATED)
    public Asignatura create(@RequestBody Asignatura asignatura) {
        return asignaturaService.save(asignatura);
    }

    @PutMapping("/asignaturas/{id}")
    public Asignatura update(@RequestBody Asignatura asignatura, @PathVariable Integer id) {
        Asignatura asignaturaActual = asignaturaService.findById(id);
        
        asignaturaActual.setCodigo(asignatura.getCodigo());
        asignaturaActual.setNombre(asignatura.getNombre());
        asignaturaActual.setDescripcion(asignatura.getDescripcion());
        asignaturaActual.setNivel(asignatura.getNivel());
        
        return asignaturaService.save(asignaturaActual);
    }

    @DeleteMapping("/asignaturas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        asignaturaService.delete(id);
    }
}
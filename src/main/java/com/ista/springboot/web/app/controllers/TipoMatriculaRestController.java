package com.ista.springboot.web.app.controllers;

import com.ista.springboot.web.app.entity.TipoMatricula;
import com.ista.springboot.web.app.service.ITipoMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TipoMatriculaRestController {

    @Autowired
    private ITipoMatriculaService tipoMatriculaService;

    @GetMapping("/tipos-matricula")
    public List<TipoMatricula> index() {
        return tipoMatriculaService.findAll();
    }

    @GetMapping("/tipos-matricula/{id}")
    public TipoMatricula show(@PathVariable Integer id) {
        return tipoMatriculaService.findById(id);
    }

    @PostMapping("/tipos-matricula")
    @ResponseStatus(HttpStatus.CREATED)
    public TipoMatricula create(@RequestBody TipoMatricula tipoMatricula) {
        return tipoMatriculaService.save(tipoMatricula);
    }

    @PutMapping("/tipos-matricula/{id}")
    public TipoMatricula update(@RequestBody TipoMatricula tipoMatricula, @PathVariable Integer id) {
        TipoMatricula tipoMatriculaActual = tipoMatriculaService.findById(id);
        
        tipoMatriculaActual.setNombre(tipoMatricula.getNombre());
        tipoMatriculaActual.setDescripcion(tipoMatricula.getDescripcion());
        
        return tipoMatriculaService.save(tipoMatriculaActual);
    }

    @DeleteMapping("/tipos-matricula/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        tipoMatriculaService.delete(id);
    }
}
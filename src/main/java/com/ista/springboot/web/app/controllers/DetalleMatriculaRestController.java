package com.ista.springboot.web.app.controllers;

import com.ista.springboot.web.app.entity.DetalleMatricula;
import com.ista.springboot.web.app.service.IDetalleMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class DetalleMatriculaRestController {

    @Autowired
    private IDetalleMatriculaService detalleMatriculaService;

    @GetMapping("/detalles-matricula")
    public List<DetalleMatricula> index() {
        return detalleMatriculaService.findAll();
    }

    @GetMapping("/detalles-matricula/{id}")
    public DetalleMatricula show(@PathVariable Integer id) {
        return detalleMatriculaService.findById(id);
    }

    @GetMapping("/detalles-matricula/matricula/{matriculaId}")
    public List<DetalleMatricula> findByMatricula(@PathVariable Integer matriculaId) {
        return detalleMatriculaService.findByMatriculaId(matriculaId);
    }

    @PostMapping("/detalles-matricula")
    @ResponseStatus(HttpStatus.CREATED)
    public DetalleMatricula create(@RequestBody DetalleMatricula detalleMatricula) {
        return detalleMatriculaService.save(detalleMatricula);
    }

    @PutMapping("/detalles-matricula/{id}")
    public DetalleMatricula update(@RequestBody DetalleMatricula detalleMatricula, @PathVariable Integer id) {
        DetalleMatricula detalleActual = detalleMatriculaService.findById(id);
        
        detalleActual.setMatricula(detalleMatricula.getMatricula());
        detalleActual.setAsignatura(detalleMatricula.getAsignatura());
        detalleActual.setNumeroMatriculaAsignatura(detalleMatricula.getNumeroMatriculaAsignatura());
        
        return detalleMatriculaService.save(detalleActual);
    }

    @DeleteMapping("/detalles-matricula/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        detalleMatriculaService.delete(id);
    }
}
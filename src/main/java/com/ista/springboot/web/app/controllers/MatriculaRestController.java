package com.ista.springboot.web.app.controllers;

import com.ista.springboot.web.app.entity.Matricula;
import com.ista.springboot.web.app.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MatriculaRestController {

    @Autowired
    private IMatriculaService matriculaService;

    @GetMapping("/matriculas")
    public List<Matricula> index() {
        return matriculaService.findAll();
    }

    @GetMapping("/matriculas/{id}")
    public Matricula show(@PathVariable Integer id) {
        return matriculaService.findById(id);
    }

    @GetMapping("/matriculas/numero/{numeroMatricula}")
    public Matricula showByNumero(@PathVariable String numeroMatricula) {
        return matriculaService.findByNumeroMatricula(numeroMatricula);
    }

    @GetMapping("/matriculas/estudiante/{estudianteId}")
    public List<Matricula> findByEstudiante(@PathVariable Integer estudianteId) {
        return matriculaService.findByEstudianteId(estudianteId);
    }

    @GetMapping("/matriculas/periodo/{periodoId}")
    public List<Matricula> findByPeriodo(@PathVariable Integer periodoId) {
        return matriculaService.findByPeriodoId(periodoId);
    }

    @PostMapping("/matriculas")
    @ResponseStatus(HttpStatus.CREATED)
    public Matricula create(@RequestBody Matricula matricula) {
        return matriculaService.save(matricula);
    }

    @PutMapping("/matriculas/{id}")
    public Matricula update(@RequestBody Matricula matricula, @PathVariable Integer id) {
        Matricula matriculaActual = matriculaService.findById(id);
        
        matriculaActual.setNumeroMatricula(matricula.getNumeroMatricula());
        matriculaActual.setEstudiante(matricula.getEstudiante());
        matriculaActual.setNivel(matricula.getNivel());
        matriculaActual.setPeriodo(matricula.getPeriodo());
        matriculaActual.setInstitucion(matricula.getInstitucion());
        matriculaActual.setParalelo(matricula.getParalelo());
        matriculaActual.setTipoMatricula(matricula.getTipoMatricula());
        matriculaActual.setCarrera(matricula.getCarrera());
        matriculaActual.setJornada(matricula.getJornada());
        matriculaActual.setFechaMatricula(matricula.getFechaMatricula());
        matriculaActual.setEstado(matricula.getEstado());
        
        return matriculaService.save(matriculaActual);
    }

    @DeleteMapping("/matriculas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        matriculaService.delete(id);
    }
}
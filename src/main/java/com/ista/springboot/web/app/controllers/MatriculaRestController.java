package com.ista.springboot.web.app.controllers;

import com.ista.springboot.web.app.entity.Matricula;
import com.ista.springboot.web.app.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
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
    public ResponseEntity<Matricula> show(@PathVariable Integer id) {
        Matricula matricula = matriculaService.findById(id);
        if (matricula == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(matricula);
    }

    @GetMapping("/matriculas/numero/{numeroMatricula}")
    public ResponseEntity<Matricula> showByNumero(@PathVariable String numeroMatricula) {
        Matricula matricula = matriculaService.findByNumeroMatricula(numeroMatricula);
        if (matricula == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(matricula);
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
    public ResponseEntity<Matricula> create(@RequestBody Matricula matricula) {
        // IMPORTANTE: No enviar idMatricula en el JSON
        matricula.setIdMatricula(null);
        Matricula nuevaMatricula = matriculaService.save(matricula);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMatricula);
    }

    @PutMapping("/matriculas/{id}")
    public ResponseEntity<Matricula> update(@RequestBody Matricula matricula, @PathVariable Integer id) {
        Matricula matriculaActual = matriculaService.findById(id);
        if (matriculaActual == null) {
            return ResponseEntity.notFound().build();
        }
        
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
        
        return ResponseEntity.ok(matriculaService.save(matriculaActual));
    }

    @DeleteMapping("/matriculas/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Matricula matricula = matriculaService.findById(id);
        if (matricula == null) {
            return ResponseEntity.notFound().build();
        }
        matriculaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
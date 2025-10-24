package com.ista.springboot.web.app.controllers;

import com.ista.springboot.web.app.entity.TipoMatricula;
import com.ista.springboot.web.app.service.ITipoMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
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
    public ResponseEntity<TipoMatricula> show(@PathVariable Integer id) {
        TipoMatricula tipoMatricula = tipoMatriculaService.findById(id);
        if (tipoMatricula == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tipoMatricula);
    }

    @PostMapping("/tipos-matricula")
    public ResponseEntity<TipoMatricula> create(@RequestBody TipoMatricula tipoMatricula) {
        tipoMatricula.setIdTipoMatricula(null);
        TipoMatricula nuevoTipo = tipoMatriculaService.save(tipoMatricula);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTipo);
    }

    @PutMapping("/tipos-matricula/{id}")
    public ResponseEntity<TipoMatricula> update(@RequestBody TipoMatricula tipoMatricula, @PathVariable Integer id) {
        TipoMatricula tipoActual = tipoMatriculaService.findById(id);
        if (tipoActual == null) {
            return ResponseEntity.notFound().build();
        }
        
        tipoActual.setNombre(tipoMatricula.getNombre());
        tipoActual.setDescripcion(tipoMatricula.getDescripcion());
        
        return ResponseEntity.ok(tipoMatriculaService.save(tipoActual));
    }

    @DeleteMapping("/tipos-matricula/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        TipoMatricula tipoMatricula = tipoMatriculaService.findById(id);
        if (tipoMatricula == null) {
            return ResponseEntity.notFound().build();
        }
        tipoMatriculaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
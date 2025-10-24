package com.ista.springboot.web.app.controllers;

import com.ista.springboot.web.app.entity.Institucion;
import com.ista.springboot.web.app.service.IInstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
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
    public ResponseEntity<Institucion> show(@PathVariable Integer id) {
        Institucion institucion = institucionService.findById(id);
        if (institucion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(institucion);
    }

    @PostMapping("/instituciones")
    public ResponseEntity<Institucion> create(@RequestBody Institucion institucion) {
        institucion.setIdInstitucion(null);
        Institucion nuevaInstitucion = institucionService.save(institucion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaInstitucion);
    }

    @PutMapping("/instituciones/{id}")
    public ResponseEntity<Institucion> update(@RequestBody Institucion institucion, @PathVariable Integer id) {
        Institucion institucionActual = institucionService.findById(id);
        if (institucionActual == null) {
            return ResponseEntity.notFound().build();
        }
        
        institucionActual.setNombre(institucion.getNombre());
        institucionActual.setTipoEducativo(institucion.getTipoEducativo());
        
        return ResponseEntity.ok(institucionService.save(institucionActual));
    }

    @DeleteMapping("/instituciones/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Institucion institucion = institucionService.findById(id);
        if (institucion == null) {
            return ResponseEntity.notFound().build();
        }
        institucionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
package com.ista.springboot.web.app.service;

import com.ista.springboot.web.app.entity.Asignatura;
import java.util.List;

public interface IAsignaturaService {
    
    List<Asignatura> findAll();
    
    Asignatura findById(Integer id);
    
    Asignatura save(Asignatura asignatura);
    
    void delete(Integer id);
    
    List<Asignatura> findByNivelId(Integer nivelId);
}
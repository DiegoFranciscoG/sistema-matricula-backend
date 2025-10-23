package com.ista.springboot.web.app.service;

import com.ista.springboot.web.app.entity.Estudiante;
import java.util.List;

public interface IEstudianteService {
    
    List<Estudiante> findAll();
    
    Estudiante findById(Integer id);
    
    Estudiante save(Estudiante estudiante);
    
    void delete(Integer id);
    
    Estudiante findByCedula(String cedula);
}
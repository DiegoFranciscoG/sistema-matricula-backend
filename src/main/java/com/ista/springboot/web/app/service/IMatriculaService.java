package com.ista.springboot.web.app.service;

import com.ista.springboot.web.app.entity.Matricula;
import java.util.List;

public interface IMatriculaService {
    
    List<Matricula> findAll();
    
    Matricula findById(Integer id);
    
    Matricula save(Matricula matricula);
    
    void delete(Integer id);
    
    Matricula findByNumeroMatricula(String numeroMatricula);
    
    List<Matricula> findByEstudianteId(Integer estudianteId);
    
    List<Matricula> findByPeriodoId(Integer periodoId);
}
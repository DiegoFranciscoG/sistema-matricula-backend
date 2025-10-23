package com.ista.springboot.web.app.service;

import com.ista.springboot.web.app.entity.Carrera;
import java.util.List;

public interface ICarreraService {
    
    List<Carrera> findAll();
    
    Carrera findById(Integer id);
    
    Carrera save(Carrera carrera);
    
    void delete(Integer id);
}
package com.ista.springboot.web.app.service;

import com.ista.springboot.web.app.entity.Jornada;
import java.util.List;

public interface IJornadaService {
    
    List<Jornada> findAll();
    
    Jornada findById(Integer id);
    
    Jornada save(Jornada jornada);
    
    void delete(Integer id);
}
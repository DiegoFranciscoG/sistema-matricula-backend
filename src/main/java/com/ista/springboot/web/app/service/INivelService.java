package com.ista.springboot.web.app.service;

import com.ista.springboot.web.app.entity.Nivel;
import java.util.List;

public interface INivelService {
    
    List<Nivel> findAll();
    
    Nivel findById(Integer id);
    
    Nivel save(Nivel nivel);
    
    void delete(Integer id);
}
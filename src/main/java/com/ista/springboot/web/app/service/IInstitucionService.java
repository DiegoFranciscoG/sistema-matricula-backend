package com.ista.springboot.web.app.service;

import com.ista.springboot.web.app.entity.Institucion;
import java.util.List;

public interface IInstitucionService {
    
    List<Institucion> findAll();
    
    Institucion findById(Integer id);
    
    Institucion save(Institucion institucion);
    
    void delete(Integer id);
}
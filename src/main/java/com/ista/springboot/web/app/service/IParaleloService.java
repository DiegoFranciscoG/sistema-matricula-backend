package com.ista.springboot.web.app.service;

import com.ista.springboot.web.app.entity.Paralelo;
import java.util.List;

public interface IParaleloService {
    
    List<Paralelo> findAll();
    
    Paralelo findById(Integer id);
    
    Paralelo save(Paralelo paralelo);
    
    void delete(Integer id);
    
    List<Paralelo> findByJornadaId(Integer jornadaId);
}
package com.ista.springboot.web.app.service;

import com.ista.springboot.web.app.entity.Periodo;
import java.util.List;

public interface IPeriodoService {
    
    List<Periodo> findAll();
    
    Periodo findById(Integer id);
    
    Periodo save(Periodo periodo);
    
    void delete(Integer id);
}
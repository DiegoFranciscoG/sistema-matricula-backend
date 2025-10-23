package com.ista.springboot.web.app.service;

import com.ista.springboot.web.app.entity.TipoMatricula;
import java.util.List;

public interface ITipoMatriculaService {
    
    List<TipoMatricula> findAll();
    
    TipoMatricula findById(Integer id);
    
    TipoMatricula save(TipoMatricula tipoMatricula);
    
    void delete(Integer id);
}
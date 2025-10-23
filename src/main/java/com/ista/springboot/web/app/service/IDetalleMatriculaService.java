package com.ista.springboot.web.app.service;

import com.ista.springboot.web.app.entity.DetalleMatricula;
import java.util.List;

public interface IDetalleMatriculaService {
    
    List<DetalleMatricula> findAll();
    
    DetalleMatricula findById(Integer id);
    
    DetalleMatricula save(DetalleMatricula detalleMatricula);
    
    void delete(Integer id);
    
    List<DetalleMatricula> findByMatriculaId(Integer matriculaId);
}
package com.ista.springboot.web.app.dao;

import org.springframework.data.repository.CrudRepository;
import com.ista.springboot.web.app.entity.TipoMatricula;

public interface ITipoMatriculaDao extends CrudRepository<TipoMatricula, Integer> {
    
}
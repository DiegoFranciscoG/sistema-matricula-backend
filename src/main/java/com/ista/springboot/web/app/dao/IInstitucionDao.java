package com.ista.springboot.web.app.dao;

import org.springframework.data.repository.CrudRepository;
import com.ista.springboot.web.app.entity.Institucion;

public interface IInstitucionDao extends CrudRepository<Institucion, Integer> {
    
}
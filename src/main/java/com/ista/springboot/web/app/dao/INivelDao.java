package com.ista.springboot.web.app.dao;

import org.springframework.data.repository.CrudRepository;
import com.ista.springboot.web.app.entity.Nivel;

public interface INivelDao extends CrudRepository<Nivel, Integer> {
    
}
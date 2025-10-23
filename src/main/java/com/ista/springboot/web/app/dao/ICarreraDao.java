package com.ista.springboot.web.app.dao;

import org.springframework.data.repository.CrudRepository;
import com.ista.springboot.web.app.entity.Carrera;

public interface ICarreraDao extends CrudRepository<Carrera, Integer> {
    
}
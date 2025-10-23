package com.ista.springboot.web.app.dao;

import org.springframework.data.repository.CrudRepository;
import com.ista.springboot.web.app.entity.Periodo;

public interface IPeriodoDao extends CrudRepository<Periodo, Integer> {
    
}
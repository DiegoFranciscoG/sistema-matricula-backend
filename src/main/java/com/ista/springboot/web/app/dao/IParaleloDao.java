package com.ista.springboot.web.app.dao;

import org.springframework.data.repository.CrudRepository;
import com.ista.springboot.web.app.entity.Paralelo;
import java.util.List;

public interface IParaleloDao extends CrudRepository<Paralelo, Integer> {
    
    // Buscar paralelos por jornada
    List<Paralelo> findByJornadaIdJornada(Integer jornadaId);
}
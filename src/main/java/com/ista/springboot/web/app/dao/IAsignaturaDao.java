package com.ista.springboot.web.app.dao;

import org.springframework.data.repository.CrudRepository;
import com.ista.springboot.web.app.entity.Asignatura;
import java.util.List;

public interface IAsignaturaDao extends CrudRepository<Asignatura, Integer> {
    
    // Buscar asignaturas por nivel
    List<Asignatura> findByNivelIdNivel(Integer nivelId);
    
    // Buscar por codigo
    Asignatura findByCodigo(String codigo);
}
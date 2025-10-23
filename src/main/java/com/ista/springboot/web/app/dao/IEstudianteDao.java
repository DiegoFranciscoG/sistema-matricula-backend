package com.ista.springboot.web.app.dao;

import org.springframework.data.repository.CrudRepository;
import com.ista.springboot.web.app.entity.Estudiante;
import java.util.Optional;

public interface IEstudianteDao extends CrudRepository<Estudiante, Integer> {
    
    // Buscar estudiante por cedula
    Optional<Estudiante> findByCedula(String cedula);
    
    // Verificar si existe por cedula
    boolean existsByCedula(String cedula);
    
    // Verificar si existe por email
    boolean existsByEmail(String email);
}
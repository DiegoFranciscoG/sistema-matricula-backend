package com.ista.springboot.web.app.dao;

import org.springframework.data.repository.CrudRepository;
import com.ista.springboot.web.app.entity.Matricula;
import java.util.List;
import java.util.Optional;

public interface IMatriculaDao extends CrudRepository<Matricula, Integer> {
    
    // Buscar por numero de matricula
    Optional<Matricula> findByNumeroMatricula(String numeroMatricula);
    
    // Buscar matriculas de un estudiante
    List<Matricula> findByEstudianteIdEstudiante(Integer estudianteId);
    
    // Buscar matriculas de un periodo
    List<Matricula> findByPeriodoIdPeriodo(Integer periodoId);
    
    // Buscar matriculas activas de un estudiante
    List<Matricula> findByEstudianteIdEstudianteAndEstado(Integer estudianteId, Matricula.EstadoMatricula estado);
    
    // Verificar si existe matricula para estudiante en periodo
    boolean existsByEstudianteIdEstudianteAndPeriodoIdPeriodo(Integer estudianteId, Integer periodoId);
}
package com.ista.springboot.web.app.dao;

import org.springframework.data.repository.CrudRepository;
import com.ista.springboot.web.app.entity.DetalleMatricula;
import java.util.List;

public interface IDetalleMatriculaDao extends CrudRepository<DetalleMatricula, Integer> {
    
    // Buscar detalles por matricula
    List<DetalleMatricula> findByMatriculaIdMatricula(Integer matriculaId);
    
    // Buscar detalles por asignatura
    List<DetalleMatricula> findByAsignaturaIdAsignatura(Integer asignaturaId);
    
    // Verificar si estudiante ya tiene asignatura matriculada
    boolean existsByMatriculaIdMatriculaAndAsignaturaIdAsignatura(Integer matriculaId, Integer asignaturaId);
}

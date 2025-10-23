package com.ista.springboot.web.app.service;

import com.ista.springboot.web.app.dao.IMatriculaDao;
import com.ista.springboot.web.app.entity.Matricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private IMatriculaDao matriculaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Matricula> findAll() {
        return (List<Matricula>) matriculaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Matricula findById(Integer id) {
        return matriculaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Matricula save(Matricula matricula) {
        return matriculaDao.save(matricula);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        matriculaDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Matricula findByNumeroMatricula(String numeroMatricula) {
        return matriculaDao.findByNumeroMatricula(numeroMatricula).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Matricula> findByEstudianteId(Integer estudianteId) {
        return matriculaDao.findByEstudianteIdEstudiante(estudianteId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Matricula> findByPeriodoId(Integer periodoId) {
        return matriculaDao.findByPeriodoIdPeriodo(periodoId);
    }
}
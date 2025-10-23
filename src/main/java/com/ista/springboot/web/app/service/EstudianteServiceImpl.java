package com.ista.springboot.web.app.service;

import com.ista.springboot.web.app.dao.IEstudianteDao;
import com.ista.springboot.web.app.entity.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

    @Autowired
    private IEstudianteDao estudianteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Estudiante> findAll() {
        return (List<Estudiante>) estudianteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Estudiante findById(Integer id) {
        return estudianteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Estudiante save(Estudiante estudiante) {
        return estudianteDao.save(estudiante);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        estudianteDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Estudiante findByCedula(String cedula) {
        return estudianteDao.findByCedula(cedula).orElse(null);
    }
}
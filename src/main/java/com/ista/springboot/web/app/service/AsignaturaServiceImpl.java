package com.ista.springboot.web.app.service;

import com.ista.springboot.web.app.dao.IAsignaturaDao;
import com.ista.springboot.web.app.entity.Asignatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class AsignaturaServiceImpl implements IAsignaturaService {

    @Autowired
    private IAsignaturaDao asignaturaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Asignatura> findAll() {
        return (List<Asignatura>) asignaturaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Asignatura findById(Integer id) {
        return asignaturaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Asignatura save(Asignatura asignatura) {
        return asignaturaDao.save(asignatura);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        asignaturaDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Asignatura> findByNivelId(Integer nivelId) {
        return asignaturaDao.findByNivelIdNivel(nivelId);
    }
}
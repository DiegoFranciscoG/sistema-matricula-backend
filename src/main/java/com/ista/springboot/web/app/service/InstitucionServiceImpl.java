package com.ista.springboot.web.app.service;

import com.ista.springboot.web.app.dao.IInstitucionDao;
import com.ista.springboot.web.app.entity.Institucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class InstitucionServiceImpl implements IInstitucionService {

    @Autowired
    private IInstitucionDao institucionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Institucion> findAll() {
        return (List<Institucion>) institucionDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Institucion findById(Integer id) {
        return institucionDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Institucion save(Institucion institucion) {
        return institucionDao.save(institucion);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        institucionDao.deleteById(id);
    }
}
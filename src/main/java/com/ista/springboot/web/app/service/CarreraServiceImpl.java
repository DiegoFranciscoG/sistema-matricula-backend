package com.ista.springboot.web.app.service;

import com.ista.springboot.web.app.dao.ICarreraDao;
import com.ista.springboot.web.app.entity.Carrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CarreraServiceImpl implements ICarreraService {

    @Autowired
    private ICarreraDao carreraDao;

    @Override
    @Transactional(readOnly = true)
    public List<Carrera> findAll() {
        return (List<Carrera>) carreraDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Carrera findById(Integer id) {
        return carreraDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Carrera save(Carrera carrera) {
        return carreraDao.save(carrera);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        carreraDao.deleteById(id);
    }
}
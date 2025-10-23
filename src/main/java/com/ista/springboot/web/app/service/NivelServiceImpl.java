package com.ista.springboot.web.app.service;

import com.ista.springboot.web.app.dao.INivelDao;
import com.ista.springboot.web.app.entity.Nivel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class NivelServiceImpl implements INivelService {

    @Autowired
    private INivelDao nivelDao;

    @Override
    @Transactional(readOnly = true)
    public List<Nivel> findAll() {
        return (List<Nivel>) nivelDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Nivel findById(Integer id) {
        return nivelDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Nivel save(Nivel nivel) {
        return nivelDao.save(nivel);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        nivelDao.deleteById(id);
    }
}
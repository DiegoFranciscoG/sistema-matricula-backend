package com.ista.springboot.web.app.service;

import com.ista.springboot.web.app.dao.IJornadaDao;
import com.ista.springboot.web.app.entity.Jornada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class JornadaServiceImpl implements IJornadaService {

    @Autowired
    private IJornadaDao jornadaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Jornada> findAll() {
        return (List<Jornada>) jornadaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Jornada findById(Integer id) {
        return jornadaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Jornada save(Jornada jornada) {
        return jornadaDao.save(jornada);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        jornadaDao.deleteById(id);
    }
}
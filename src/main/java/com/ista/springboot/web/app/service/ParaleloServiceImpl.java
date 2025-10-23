package com.ista.springboot.web.app.service;

import com.ista.springboot.web.app.dao.IParaleloDao;
import com.ista.springboot.web.app.entity.Paralelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ParaleloServiceImpl implements IParaleloService {

    @Autowired
    private IParaleloDao paraleloDao;

    @Override
    @Transactional(readOnly = true)
    public List<Paralelo> findAll() {
        return (List<Paralelo>) paraleloDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Paralelo findById(Integer id) {
        return paraleloDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Paralelo save(Paralelo paralelo) {
        return paraleloDao.save(paralelo);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        paraleloDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Paralelo> findByJornadaId(Integer jornadaId) {
        return paraleloDao.findByJornadaIdJornada(jornadaId);
    }
}
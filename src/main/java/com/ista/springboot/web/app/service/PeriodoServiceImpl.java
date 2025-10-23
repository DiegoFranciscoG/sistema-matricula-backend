package com.ista.springboot.web.app.service;

import com.ista.springboot.web.app.dao.IPeriodoDao;
import com.ista.springboot.web.app.entity.Periodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PeriodoServiceImpl implements IPeriodoService {

    @Autowired
    private IPeriodoDao periodoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Periodo> findAll() {
        return (List<Periodo>) periodoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Periodo findById(Integer id) {
        return periodoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Periodo save(Periodo periodo) {
        return periodoDao.save(periodo);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        periodoDao.deleteById(id);
    }
}
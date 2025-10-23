package com.ista.springboot.web.app.service;

import com.ista.springboot.web.app.dao.ITipoMatriculaDao;
import com.ista.springboot.web.app.entity.TipoMatricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class TipoMatriculaServiceImpl implements ITipoMatriculaService {

    @Autowired
    private ITipoMatriculaDao tipoMatriculaDao;

    @Override
    @Transactional(readOnly = true)
    public List<TipoMatricula> findAll() {
        return (List<TipoMatricula>) tipoMatriculaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public TipoMatricula findById(Integer id) {
        return tipoMatriculaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public TipoMatricula save(TipoMatricula tipoMatricula) {
        return tipoMatriculaDao.save(tipoMatricula);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        tipoMatriculaDao.deleteById(id);
    }
}
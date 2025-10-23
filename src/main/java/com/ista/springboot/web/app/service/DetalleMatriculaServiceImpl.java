package com.ista.springboot.web.app.service;

import com.ista.springboot.web.app.dao.IDetalleMatriculaDao;
import com.ista.springboot.web.app.entity.DetalleMatricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class DetalleMatriculaServiceImpl implements IDetalleMatriculaService {

    @Autowired
    private IDetalleMatriculaDao detalleMatriculaDao;

    @Override
    @Transactional(readOnly = true)
    public List<DetalleMatricula> findAll() {
        return (List<DetalleMatricula>) detalleMatriculaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public DetalleMatricula findById(Integer id) {
        return detalleMatriculaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public DetalleMatricula save(DetalleMatricula detalleMatricula) {
        return detalleMatriculaDao.save(detalleMatricula);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        detalleMatriculaDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DetalleMatricula> findByMatriculaId(Integer matriculaId) {
        return detalleMatriculaDao.findByMatriculaIdMatricula(matriculaId);
    }
}
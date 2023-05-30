package com.ppt.ppt.daoImp;

import com.ppt.ppt.dao.Estudiante_ApoyoDao;
import com.ppt.ppt.models.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class Estudiante_ApoyoDaoImp implements Estudiante_ApoyoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void seleccionarEstudianteApoyo(List<Estudiante> e) {

    }
}

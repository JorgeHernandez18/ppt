package com.ppt.ppt.daoImp;

import com.ppt.ppt.dao.GradoDao;
import com.ppt.ppt.models.Grado;
import com.ppt.ppt.models.ProyectoAula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class GradoDaoImp implements GradoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Grado> getGrado() {
        String query ="FROM Grado";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Grado getGrado(int id) {
        return entityManager.find(Grado.class, id);
    }

    @Override
    public void createGrado(Grado grado) {
        entityManager.merge(grado);
    }
}

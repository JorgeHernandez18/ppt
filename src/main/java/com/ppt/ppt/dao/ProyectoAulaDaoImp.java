package com.ppt.ppt.dao;


import com.ppt.ppt.models.ProyectoAula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProyectoAulaDaoImp implements ProyectoAulaDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<ProyectoAula> getProyectoAula() {
        String query ="FROM ProyectoAula";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void deleteProyectoAula(int id) {
        ProyectoAula pa = entityManager.find(ProyectoAula.class, id);
        entityManager.remove(pa);
    }
}

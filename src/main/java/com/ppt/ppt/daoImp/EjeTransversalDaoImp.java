package com.ppt.ppt.daoImp;

import com.ppt.ppt.dao.EjeTransversalDao;
import com.ppt.ppt.models.EjeTransversal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EjeTransversalDaoImp implements EjeTransversalDao {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<EjeTransversal> getEjeTransversal() {
        String query ="FROM EjeTransversal";
        return entityManager.createQuery(query).getResultList();
    }
}

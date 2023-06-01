package com.ppt.ppt.daoImp;

import com.ppt.ppt.dao.TipoEjeTransversalDao;
import com.ppt.ppt.models.TipoEjeTransversal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TipoEjeTransversalDaoImp implements TipoEjeTransversalDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<TipoEjeTransversal> getTipoEjeTransversal() {
        String query ="FROM TipoEjeTransversal";
        return entityManager.createQuery(query).getResultList();
    }
}

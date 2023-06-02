package com.ppt.ppt.daoImp;

import com.ppt.ppt.dao.TipoEjeTransversalDao;
import com.ppt.ppt.models.EjeTransversal;
import com.ppt.ppt.models.TipoEjeTransversal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Override
    public TipoEjeTransversal getTipoEjeTransversal(int id) {
        return entityManager.find(TipoEjeTransversal.class, id);
    }

    @Override
    public List<TipoEjeTransversal> getTipoEjeTransversalByEje(int id) {
        EjeTransversal et = entityManager.find(EjeTransversal.class, id);
        List<TipoEjeTransversal> tet = getTipoEjeTransversal();

        List<TipoEjeTransversal> texej = new ArrayList<>();

        for (TipoEjeTransversal te : tet){
            if(te.getId_eje_transversal() == et.getId()){
                texej.add(te);
            }
        }
        return texej;
    }
}

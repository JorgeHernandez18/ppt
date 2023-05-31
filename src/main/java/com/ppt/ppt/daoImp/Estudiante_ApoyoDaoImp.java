package com.ppt.ppt.daoImp;

import com.ppt.ppt.dao.Estudiante_ApoyoDao;
import com.ppt.ppt.models.Estudiante;
import com.ppt.ppt.models.Estudiante_Apoyo;
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
    public List<Estudiante_Apoyo> getEstudiante_Apoyo() {
        String query = "FROM Estudiante_Apoyo";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void seleccionarEstudianteApoyo(List<Estudiante> e) {
        String query = "FROM Estudiante_Apoyo";
        entityManager.createQuery(query).getResultList();
    }

}

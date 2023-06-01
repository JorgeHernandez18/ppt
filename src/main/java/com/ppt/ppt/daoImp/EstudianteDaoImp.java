package com.ppt.ppt.daoImp;

import com.ppt.ppt.dao.EstudianteDao;
import com.ppt.ppt.models.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EstudianteDaoImp implements EstudianteDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Estudiante> getEstudiante() {
        String query = "FROM Estudiante";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Estudiante getEstudiante(String correo) throws Exception {
        try {
            String query = "FROM Estudiante WHERE correo_electronico = :correo";
            Estudiante e = (Estudiante) entityManager.createQuery(query)
                    .setParameter("correo", correo)
                    .getSingleResult();
            return e;
        }catch (NoResultException e){
         return null;
        }
    }

    @Override
    public void createEstudiante(Estudiante estudiante) {
        entityManager.merge(estudiante);
    }
}

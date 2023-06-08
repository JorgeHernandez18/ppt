package com.ppt.ppt.daoImp;

import com.ppt.ppt.dao.EstudianteDao;
import com.ppt.ppt.models.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Repository
@Transactional
public class EstudianteDaoImp implements EstudianteDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Estudiante> getEstudiantes(String q) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Estudiante> criteriaQuery = criteriaBuilder.createQuery(Estudiante.class);
        Root<Estudiante> root = criteriaQuery.from(Estudiante.class);
        criteriaQuery.select(root);

        List<Estudiante> estudiantes = new LinkedList<>();

        if (q != null && !q.equals("")) {
            criteriaQuery.where(criteriaBuilder.like(root.get("codigo").as(String.class), "%" + q + "%"));

            TypedQuery<Estudiante> query = entityManager.createQuery(criteriaQuery);

            estudiantes = query.getResultList();
        }

        return estudiantes;
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

    @Override
    public Estudiante getEstudianteById(int id) {
        return entityManager.find(Estudiante.class, id);
    }
}

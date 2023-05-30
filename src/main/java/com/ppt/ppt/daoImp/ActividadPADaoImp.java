package com.ppt.ppt.daoImp;

import com.ppt.ppt.dao.ActividadPADao;
import com.ppt.ppt.models.ActividadPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ActividadPADaoImp implements ActividadPADao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<ActividadPA> getActividadPA() {
        String query ="FROM ActividadPA";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public ActividadPA getActividadPA(int id) {
        return entityManager.find(ActividadPA.class, id);
    }

    @Override
    public void deleteActividadPA(int id) {
        ActividadPA apa = entityManager.find(ActividadPA.class, id);
        entityManager.remove(apa);
    }

    @Override
    public void updateActividadPA(ActividadPA actividadPA, int id) {
        ActividadPA apa = entityManager.find(ActividadPA.class, id);
        apa.setNombre(actividadPA.getNombre());
        apa.setFecha_inicio(actividadPA.getFecha_inicio());
        apa.setFecha_fin(actividadPA.getFecha_fin());
        apa.setEstudiante(actividadPA.getEstudiante());
        apa.setCumplimiento(actividadPA.getCumplimiento());
        apa.setObservacion(actividadPA.getObservacion());
        apa.setProyecto_aula(actividadPA.getProyecto_aula());

        entityManager.merge(apa);
    }

    @Override
    public void createActividadPA(ActividadPA actividadPA) {
        entityManager.merge(actividadPA);
    }
}

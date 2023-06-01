package com.ppt.ppt.daoImp;

import com.ppt.ppt.dao.ActividadPTDao;
import com.ppt.ppt.models.ActividadPT;
import com.ppt.ppt.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ActividadPTDaoImp implements ActividadPTDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<ActividadPT> getActividadPT() {
        String query ="FROM ActividadPT";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public ActividadPT getActividadPT(int id) {
        return entityManager.find(ActividadPT.class, id);
    }

    @Override
    public void deleteActividadPT(int id) {
        ActividadPT apt = entityManager.find(ActividadPT.class, id);
        entityManager.remove(apt);
    }

    @Override
    public void updateActividadPT(ActividadPT actividadPT, int id) {
        ActividadPT apt = entityManager.find(ActividadPT.class, id);
        apt.setNombre(actividadPT.getNombre());
        apt.setFecha_inicio(actividadPT.getFecha_inicio());
        apt.setFecha_fin(actividadPT.getFecha_fin());
        apt.setDocente_apoyo(actividadPT.getDocente_apoyo());
        apt.setCumplimiento(actividadPT.getCumplimiento());
        apt.setObservacion(actividadPT.getObservacion());
        apt.setPlan_trabajo(actividadPT.getPlan_trabajo());

        entityManager.merge(apt);
    }

    @Override
    public void createActividadPT(ActividadPT actividadPT) {entityManager.merge(actividadPT);}

}

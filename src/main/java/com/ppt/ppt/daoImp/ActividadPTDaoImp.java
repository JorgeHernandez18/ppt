package com.ppt.ppt.daoImp;

import com.ppt.ppt.dao.ActividadPTDao;
import com.ppt.ppt.dao.PlanTrabajoDao;
import com.ppt.ppt.models.ActividadPT;
import com.ppt.ppt.models.PlanTrabajo;
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
    public ActividadPT getActividadPT(Integer id) {
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
        apt.setPt(actividadPT.getPt());

        entityManager.merge(apt);
    }

    @Override
    public void createActividadPT(ActividadPT actividadPT, Integer id) {
        PlanTrabajo pt = entityManager.find(PlanTrabajo.class, id);
        actividadPT.setPt(pt);

        //Ya se está guardando la actividad en la base de datos.
        pt.getActividades().add(actividadPT);
        entityManager.merge(pt);
        //entityManager.merge(actividadPT);
    }

}

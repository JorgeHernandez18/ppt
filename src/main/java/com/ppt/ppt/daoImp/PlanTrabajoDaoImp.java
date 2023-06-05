package com.ppt.ppt.daoImp;

import com.ppt.ppt.dao.PlanTrabajoDao;
import com.ppt.ppt.models.ActividadPA;
import com.ppt.ppt.models.ActividadPT;
import com.ppt.ppt.models.PlanTrabajo;
import com.ppt.ppt.models.ProyectoAula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class PlanTrabajoDaoImp implements PlanTrabajoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<PlanTrabajo> getPlanTrabajo() {
        String query ="FROM PlanTrabajo";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public PlanTrabajo getPlanTrabajo(int id) {
        return entityManager.find(PlanTrabajo.class, id);
    }

    @Override
    public void deletePlanTrabajo(int id) {
        PlanTrabajo pt = entityManager.find(PlanTrabajo.class, id);
        entityManager.remove(pt);
    }

    @Override
    public void updatePlanTrabajo(PlanTrabajo planTrabajo, int id) {
        PlanTrabajo pt = entityManager.find(PlanTrabajo.class, id);
        pt.setAnio(planTrabajo.getAnio());
        pt.setId_eje_transversal(planTrabajo.getId_eje_transversal());
        pt.setActividad_pt(planTrabajo.getActividad_pt());
        pt.setCierre(planTrabajo.getCierre());
        entityManager.merge(pt);
    }

    @Override
    public void createPlanTrabajo(PlanTrabajo planTrabajo) {
        entityManager.merge(planTrabajo);
    }

    @Override
    public void cargarActividades(ActividadPT actividad) {
        PlanTrabajo pt = entityManager.find(PlanTrabajo.class, actividad.getPt().getId());

        pt.setActividades((Set<ActividadPT>) actividad);
    }

    @Override
    public List<ActividadPT> listarActividadesDeCadaPlan(int id) {
        PlanTrabajo pt = entityManager.find(PlanTrabajo.class, id);
        Set<ActividadPT> actividades = pt.getActividades();
        List<ActividadPT> actividadesPT= new ArrayList<>();
        for(ActividadPT a: actividades){
            if(pt.getId() == a.getPt().getId())
            {
                actividadesPT.add(a);
            }
        }
        return actividadesPT;
    }
}

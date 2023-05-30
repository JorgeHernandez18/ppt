package com.ppt.ppt.dao;

import com.ppt.ppt.models.PlanTrabajo;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlanTrabajoDaoImp implements PlanTrabajoDao{

    @Autowired
    EntityManager entityManager;

    @Override
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
}

package com.ppt.ppt.dao;

import com.ppt.ppt.models.PlanTrabajo;
import java.util.List;

public interface PlanTrabajoDao {

    List<PlanTrabajo> getPlanTrabajo();

    PlanTrabajo getPlanTrabajo(int id);

    void deletePlanTrabajo(int id);

    void updatePlanTrabajo(PlanTrabajo planTrabajo, int id);

    void createPlanTrabajo(PlanTrabajo planTrabajo);
}
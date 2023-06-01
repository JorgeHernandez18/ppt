package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.PlanTrabajoDao;
import com.ppt.ppt.models.PlanTrabajo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pt")
public class PlanTrabajoController {

    @Autowired
    private PlanTrabajoDao planTrabajoDao;

    @RequestMapping(value = "api/plantrabajo")
    public List<PlanTrabajo> getPlanTrabajo(){ return planTrabajoDao.getPlanTrabajo();}

    @RequestMapping(value = "api/plantrabajo/{id}")
    public PlanTrabajo getPlanTrabajo(@PathVariable int id){
        return planTrabajoDao.getPlanTrabajo(id);
    }

    @RequestMapping(value = "api/plantrabajo/{id}", method = RequestMethod.DELETE)
    public void deletePlanTrabajo(@PathVariable int id){
        planTrabajoDao.deletePlanTrabajo(id);
    }

    @RequestMapping(value = "api/plantrabajo/{id}", method = RequestMethod.PUT)
    public void updatePlanTrabajo(@RequestBody PlanTrabajo planTrabajo, @PathVariable int id){
        planTrabajoDao.updatePlanTrabajo(planTrabajo,id);
    }

    //Funcionando correctamente
    @RequestMapping(value = "api/plantrabajo", method = RequestMethod.POST)
    public void createPlanTrabajo(@RequestBody PlanTrabajo planTrabajo){
        planTrabajoDao.createPlanTrabajo(planTrabajo);
    }

}

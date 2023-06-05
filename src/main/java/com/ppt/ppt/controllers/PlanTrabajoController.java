package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.PlanTrabajoDao;
import com.ppt.ppt.models.ActividadPT;
import com.ppt.ppt.models.PlanTrabajo;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pt")
public class PlanTrabajoController {

    @Autowired
    private PlanTrabajoDao planTrabajoDao;

    //Funciona correctamente
    @RequestMapping(value = "api/plantrabajo", method = RequestMethod.GET)
    public List<PlanTrabajo> getPlanTrabajo(){ return planTrabajoDao.getPlanTrabajo();}

    //Funciona correctamente, con control de id
    @RequestMapping(value = "api/plantrabajo/{id}", method = RequestMethod.GET)
    public PlanTrabajo getPlanTrabajo(@PathVariable int id, HttpServletResponse response){
        if(planTrabajoDao.getPlanTrabajo(id) == null){
            response.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        return planTrabajoDao.getPlanTrabajo(id);
    }

    //Con control de id
    @RequestMapping(value = "api/plantrabajo/{id}", method = RequestMethod.DELETE)
    public void deletePlanTrabajo(@PathVariable int id, HttpServletResponse response){

        if(planTrabajoDao.getPlanTrabajo(id) == null){
            response.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        planTrabajoDao.deletePlanTrabajo(id);
    }

    //Funciona correctamente, sin control de id
    @RequestMapping(value = "api/plantrabajo/{id}", method = RequestMethod.PUT)
    public void updatePlanTrabajo(@RequestBody PlanTrabajo planTrabajo, @PathVariable int id, HttpServletResponse response){
        if(planTrabajoDao.getPlanTrabajo(id) == null){
            response.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        planTrabajoDao.updatePlanTrabajo(planTrabajo,id);
    }

    //Funcionando correctamente
    @RequestMapping(value = "api/plantrabajo", method = RequestMethod.POST)
    public void createPlanTrabajo(@RequestBody PlanTrabajo planTrabajo){
        planTrabajoDao.createPlanTrabajo(planTrabajo);
    }

    @RequestMapping(value = "api/actividadespt/{id}", method = RequestMethod.GET)
    public List<ActividadPT> listarActividadesDeCadaPlan(int id, HttpServletResponse response){
        if(planTrabajoDao.getPlanTrabajo(id) == null){
            response.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        return planTrabajoDao.listarActividadesDeCadaPlan(id);
    }

}

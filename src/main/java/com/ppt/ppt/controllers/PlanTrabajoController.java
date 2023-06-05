package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.PlanTrabajoDao;
import com.ppt.ppt.models.ActividadPT;
import com.ppt.ppt.models.PlanTrabajo;
import com.ppt.ppt.models.Token;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pt")
public class PlanTrabajoController {

    @Autowired
    private PlanTrabajoDao planTrabajoDao;

    //Funciona correctamente
    @RequestMapping(value = "api/plantrabajo", method = RequestMethod.GET)
    public ResponseEntity<List<PlanTrabajo>> getPlanTrabajo(){ return ResponseEntity.ok(planTrabajoDao.getPlanTrabajo());}

    //Funciona correctamente, con control de id
    @RequestMapping(value = "api/plantrabajo/{id}", method = RequestMethod.GET)
    public ResponseEntity<PlanTrabajo> getPlanTrabajo(@PathVariable int id){
        if(planTrabajoDao.getPlanTrabajo(id) == null){
            throw new ErrorResponseException(HttpStatusCode.valueOf(404), new Exception("Plan de trabajo no existente"));
        }
        return ResponseEntity.ok(planTrabajoDao.getPlanTrabajo(id));
    }

    //Con control de id
    @RequestMapping(value = "api/plantrabajo/{id}", method = RequestMethod.DELETE)
    public void deletePlanTrabajo(@PathVariable int id){

        if(planTrabajoDao.getPlanTrabajo(id) == null){
            throw new ErrorResponseException(HttpStatusCode.valueOf(404), new Exception("Plan de trabajo no existente"));
        }
        planTrabajoDao.deletePlanTrabajo(id);
    }

    //Funciona correctamente, sin control de id
    @RequestMapping(value = "api/plantrabajo/{id}", method = RequestMethod.PUT)
    public void updatePlanTrabajo(@RequestBody PlanTrabajo planTrabajo, @PathVariable int id){
        if(planTrabajoDao.getPlanTrabajo(id) == null){
            throw new ErrorResponseException(HttpStatusCode.valueOf(404), new Exception("Plan de trabajo no existente"));
        }
        planTrabajoDao.updatePlanTrabajo(planTrabajo, id);
    }

    //Funcionando correctamente
    @RequestMapping(value = "api/plantrabajo", method = RequestMethod.POST)
    public void createPlanTrabajo(@RequestBody PlanTrabajo planTrabajo){
        planTrabajoDao.createPlanTrabajo(planTrabajo);
    }

    @RequestMapping(value = "api/actividadespt/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ActividadPT>>  listarActividadesDeCadaPlan(int id){
        if(planTrabajoDao.getPlanTrabajo(id) == null){
            throw new ErrorResponseException(HttpStatusCode.valueOf(404), new Exception("Plan de trabajo no existente"));
        }
        return ResponseEntity.ok(planTrabajoDao.listarActividadesDeCadaPlan(id));
    }
}
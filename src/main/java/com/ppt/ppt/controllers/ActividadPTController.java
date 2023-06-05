package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.ActividadPTDao;
import com.ppt.ppt.dao.PlanTrabajoDao;
import com.ppt.ppt.models.ActividadPT;
import com.ppt.ppt.models.EjeTransversal;
import com.ppt.ppt.models.PlanTrabajo;
import com.ppt.ppt.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apt")
public class ActividadPTController {

    @Autowired
    private ActividadPTDao actividadPTDao;

    @Autowired
    private PlanTrabajoDao planTrabajoDao;
    //Funciona correctamente
    @RequestMapping(value = "api/actividadpt", method = RequestMethod.GET)
    public ResponseEntity<List<ActividadPT>>  getActividadPT(){ return ResponseEntity.ok(actividadPTDao.getActividadPT());}

    //Funciona correctamente
    @RequestMapping(value = "api/actividadpt/{id}", method = RequestMethod.GET)
    public ResponseEntity<ActividadPT> getActividadPT(@PathVariable int id) {
        if (actividadPTDao.getActividadPT(id) == null) {
            throw new ErrorResponseException(HttpStatusCode.valueOf(404), new Exception("Actividad no existente"));
        } else {
            return ResponseEntity.ok(actividadPTDao.getActividadPT(id));
        }
    }

    @RequestMapping(value = "api/actividadpt/{id}", method = RequestMethod.DELETE)
    public void deleteActividadPT(@RequestBody ActividadPT actividadPT){
        if (actividadPTDao.getActividadPT(actividadPT.getId()) == null) {
            throw new ErrorResponseException(HttpStatusCode.valueOf(404), new Exception("Actividad no existente"));
        } else {
            planTrabajoDao.eliminarActividades(actividadPT);
            actividadPTDao.deleteActividadPT(actividadPT.getId());
        }

    }

    //Funciona correctamente
    @RequestMapping(value = "api/actividadpt", method = RequestMethod.POST)
    public void createActividadPT(@RequestBody ActividadPT actividadPT, @PathVariable int idPT) {
        PlanTrabajo pt = planTrabajoDao.getPlanTrabajo(idPT);
        actividadPT.setPt(pt);

        planTrabajoDao.cargarActividades(actividadPT);
        actividadPTDao.createActividadPT(actividadPT);
    }

    //Funciona correctamente
    @RequestMapping(value = "api/actividadpt/{id}", method = RequestMethod.PUT)
    public void updateActividadPT(@RequestBody ActividadPT actividadPT, @PathVariable int id){
        if (actividadPTDao.getActividadPT(id) == null) {
            throw new ErrorResponseException(HttpStatusCode.valueOf(404), new Exception("Actividad no existente"));
        } else {
            actividadPTDao.updateActividadPT(actividadPT,id);
        }

    }


}

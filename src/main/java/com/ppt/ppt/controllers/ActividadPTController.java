package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.ActividadPTDao;
import com.ppt.ppt.dao.PlanTrabajoDao;
import com.ppt.ppt.models.ActividadPT;
import com.ppt.ppt.models.PlanTrabajo;
import com.ppt.ppt.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ActividadPT> getActividadPT(){ return actividadPTDao.getActividadPT();}

    //Funciona correctamente
    @RequestMapping(value = "api/actividadpt/{id}", method = RequestMethod.GET)
    public ActividadPT getActividadPT(@PathVariable int id){
        return actividadPTDao.getActividadPT(id);
    }

    //Funciona correctamente
    @RequestMapping(value = "api/actividadpt/{id}", method = RequestMethod.DELETE)
    public void deleteActividadPT(@PathVariable int id){
        actividadPTDao.deleteActividadPT(id);
    }

    //Funciona correctamente
    @RequestMapping(value = "api/actividadpt/{id}", method = RequestMethod.PUT)
    public void updateActividadPT(@RequestBody ActividadPT actividadPT, @PathVariable int id){
        actividadPTDao.updateActividadPT(actividadPT,id);
    }

    //Funciona correctamente
    @RequestMapping(value = "api/actividadpt", method = RequestMethod.POST)
    public void createActividadPT(@RequestBody ActividadPT actividadPT, @PathVariable int idPT) {
        PlanTrabajo pt = planTrabajoDao.getPlanTrabajo(idPT);
        actividadPT.setPt(pt);

        planTrabajoDao.cargarActividades(actividadPT);
        actividadPTDao.createActividadPT(actividadPT);
    }
}

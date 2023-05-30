package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.ActividadPADao;
import com.ppt.ppt.dao.PlanTrabajoDao;
import com.ppt.ppt.models.ActividadPA;
import com.ppt.ppt.models.PlanTrabajo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apa")
public class ActividadPAController {

    @Autowired
    private ActividadPADao actividadPADao;

    @RequestMapping(value = "api/actividadpa")
    public List<ActividadPA> getActividadPA(){ return actividadPADao.getActividadPA();}

    @RequestMapping(value = "api/actividadpa/{id}")
    public ActividadPA getActividadPA(@PathVariable int id){
        return actividadPADao.getActividadPA(id);
    }

    @RequestMapping(value = "api/actividadpa/{id}", method = RequestMethod.DELETE)
    public void deleteActividadPA(@PathVariable int id){
        actividadPADao.deleteActividadPA(id);
    }

    @RequestMapping(value = "api/actividadpa/{id}", method = RequestMethod.PUT)
    public void updateActividadPA(@RequestBody ActividadPA actividadPA, @PathVariable int id){
        actividadPADao.updateActividadPA(actividadPA,id);
    }

    @RequestMapping(value = "api/actividadpa", method = RequestMethod.POST)
    public void createProyectoAula(@RequestBody ActividadPA actividadPA){
        actividadPADao.createActividadPA(actividadPA);
    }
}

package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.ActividadPTDao;
import com.ppt.ppt.models.ActividadPT;
import com.ppt.ppt.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apt")
public class ActividadPTController {

    @Autowired
    private ActividadPTDao actividadPTDao;

    //Funciona correctamente
    @RequestMapping(value = "api/actividadpt")
    public List<ActividadPT> getActividadPT(){ return actividadPTDao.getActividadPT();}

    //Funciona correctamente
    @RequestMapping(value = "api/actividadpt/{id}")
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
    public void createProyectoAula(@RequestBody ActividadPT actividadPT) {
        actividadPTDao.createActividadPT(actividadPT);
    }
}

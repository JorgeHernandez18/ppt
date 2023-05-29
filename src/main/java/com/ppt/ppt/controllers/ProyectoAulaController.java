package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.ProyectoAulaDao;
import com.ppt.ppt.models.ProyectoAula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pa")
public class ProyectoAulaController {


    @Autowired
    private ProyectoAulaDao proyectoAulaDao;

    @RequestMapping(value = "api/proyectoaula")
    public List<ProyectoAula> getProyectoAula(){ return proyectoAulaDao.getProyectoAula();}

    @RequestMapping(value = "api/proyectoaula/{id}")
    public ProyectoAula getProyectoAula(@PathVariable int id){
        return proyectoAulaDao.getProyectoAula(id);
    }

    @RequestMapping(value = "api/proyectoaula/{id}", method = RequestMethod.DELETE)
    public void deleteProyectoAula(@PathVariable int id){
        proyectoAulaDao.deleteProyectoAula(id);
    }

    @RequestMapping(value = "api/proyectoaula/{id}", method = RequestMethod.PUT)
    public void updateProyectoAula(@RequestBody ProyectoAula proyectoAula,@PathVariable int id){
        proyectoAulaDao.updateProyectoAula(proyectoAula,id);
    }

    @RequestMapping(value = "api/proyectoaula", method = RequestMethod.POST)
    public void createProyectoAula(@RequestBody ProyectoAula proyectoAula){
        proyectoAulaDao.createProyectoAula(proyectoAula);
    }
}

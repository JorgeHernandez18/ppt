package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.ProyectoAulaDao;
import com.ppt.ppt.models.ProyectoAula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProyectoAulaController {


    @Autowired
    private ProyectoAulaDao proyectoAulaDao;

    @RequestMapping(value = "api/proyectoaula")
    public List<ProyectoAula> getProyectoAula(){ return proyectoAulaDao.getProyectoAula();}

    @RequestMapping(value = "api/proyectoaula/{id}")
    public ProyectoAula getProyectoAula(@PathVariable int id){
        ProyectoAula pa = new ProyectoAula();

        return pa;
    }

    @RequestMapping(value = "api/proyectoaula/{id}", method = RequestMethod.DELETE)
    public void deleteProyectoAula(@PathVariable int id){
        proyectoAulaDao.deleteProyectoAula(id);

    }

}

package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.TipoEjeTransversalDao;
import com.ppt.ppt.models.TipoEjeTransversal;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipo_eje")
public class TipoEjeTransversalController {

    @Autowired
    private TipoEjeTransversalDao tipoEjeTransversalDao;

    @RequestMapping(value = "api/tipo_eje", method = RequestMethod.GET)
    public List<TipoEjeTransversal> getTipoEjeTransversal(){ return tipoEjeTransversalDao.getTipoEjeTransversal();}

    @RequestMapping(value = "api/tipo_ejebyideje/{id}", method = RequestMethod.GET)
    public List<TipoEjeTransversal> getTipoEjeTransversalByEje(@PathVariable int id, HttpServletResponse response){
        if(tipoEjeTransversalDao.getTipoEjeTransversal(id) == null){
            response.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        return tipoEjeTransversalDao.getTipoEjeTransversalByEje(id);}
}

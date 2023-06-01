package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.TipoEjeTransversalDao;
import com.ppt.ppt.models.TipoEjeTransversal;
import org.springframework.beans.factory.annotation.Autowired;
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
}

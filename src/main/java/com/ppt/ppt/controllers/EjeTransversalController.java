package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.EjeTransversalDao;
import com.ppt.ppt.models.EjeTransversal;
import com.ppt.ppt.models.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eje")
public class EjeTransversalController {

    @Autowired
    private EjeTransversalDao ejeTransversalDao;

    @RequestMapping(value = "api/eje", method = RequestMethod.GET)
    public ResponseEntity<List<EjeTransversal>>  getEjeTransversal(){ return ResponseEntity.ok(ejeTransversalDao.getEjeTransversal());}
}

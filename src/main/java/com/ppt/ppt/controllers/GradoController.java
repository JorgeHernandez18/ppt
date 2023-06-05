package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.GradoDao;
import com.ppt.ppt.models.Grado;
import com.ppt.ppt.models.PlanTrabajo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/grado")
public class GradoController {

    @Autowired
    private GradoDao gradoDao;

    @RequestMapping(value = "api/grado", method = RequestMethod.GET)
    public ResponseEntity<List<Grado>>  getGrado(){ return ResponseEntity.ok(gradoDao.getGrado());}

}

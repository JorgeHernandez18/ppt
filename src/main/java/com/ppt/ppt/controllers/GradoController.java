package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.GradoDao;
import com.ppt.ppt.models.Grado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/grado")
public class GradoController {

    @Autowired
    GradoDao gradoDao;

    @RequestMapping(value = "api/grado", method = RequestMethod.GET)
    public List<Grado> getGrado(){ return gradoDao.getGrado();}




}

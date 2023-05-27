package com.ppt.ppt.controllers;

import com.ppt.ppt.models.ProyectoAula;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProyectoAulaController {


@RequestMapping(value = "proyectosaula")
    public List<ProyectoAula> getProyectosAula(){ return null;}

}

package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.EstudianteDao;
import com.ppt.ppt.models.Estudiante;
import com.ppt.ppt.models.PlanTrabajo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteDao estudianteDao;

    //Funcionando correctamente
    @RequestMapping(value = "api/estudiante", method = RequestMethod.GET)
    public ResponseEntity<List<Estudiante>>  getEstudiante(){ return ResponseEntity.ok(estudianteDao.getEstudiante());}

    //Funcionando correctamente
    @RequestMapping(value = "api/estudiante", method = RequestMethod.POST)
    public void createEstudiante(@RequestBody Estudiante estudiante) throws Exception {
        Estudiante e = estudianteDao.getEstudiante(estudiante.getCorreo_electronico());
        if (e != null) {
            throw new ErrorResponseException(HttpStatusCode.valueOf(400), new Exception("Estudiante existente"));
        }else {
            estudianteDao.createEstudiante(estudiante);
        }
    }
}

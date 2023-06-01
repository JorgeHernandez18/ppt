package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.EstudianteDao;
import com.ppt.ppt.models.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteDao estudianteDao;

    //Funcionando correctamente
    @RequestMapping(value = "api/estudiante")
    public List<Estudiante> getEstudiante(){ return estudianteDao.getEstudiante();}

    //Funcionando correctamente
    @RequestMapping(value = "api/estudiante", method = RequestMethod.POST)
    public void createEstudiante(@RequestBody Estudiante estudiante) throws Exception {
        Estudiante e = estudianteDao.getEstudiante(estudiante.getCorreo_electronico());
        if (e != null) {
            throw new Exception("Email de Estudiante ya existe");
        }else {
            estudianteDao.createEstudiante(estudiante);
        }
    }
}

package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.ActividadPADao;
import com.ppt.ppt.models.ActividadPA;
import com.ppt.ppt.models.Estudiante;
import com.ppt.ppt.models.Estudiante_Apoyo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/apa")
public class ActividadPAController {

    @Autowired
    private ActividadPADao actividadPADao;

    @RequestMapping(value = "api/actividadpa")
    public List<ActividadPA> getActividadPA(){ return actividadPADao.getActividadPA();}

    @RequestMapping(value = "api/actividadpa/{id}")
    public ActividadPA getActividadPA(@PathVariable int id){
        return actividadPADao.getActividadPA(id);
    }

    @RequestMapping(value = "api/actividadpa/{id}", method = RequestMethod.DELETE)
    public void deleteActividadPA(@PathVariable int id){
        actividadPADao.deleteActividadPA(id);
    }

    @RequestMapping(value = "api/actividadpa/{id}", method = RequestMethod.PUT)
    public void updateActividadPA(@RequestBody ActividadPA actividadPA, @PathVariable int id){
        actividadPADao.updateActividadPA(actividadPA,id);
    }

    @RequestMapping(value = "api/actividadpa", method = RequestMethod.POST)
    public void createActividadPA(@RequestBody ActividadPA actividadPA) {
        Set<Estudiante_Apoyo> ea = new HashSet<>();

        Estudiante estudiante = new Estudiante();
        estudiante.setCodigo(1151811);
        estudiante.setNombre("Jorge");
        estudiante.setApellido("Hernandez");
        estudiante.setCorreo_electronico("herlasso@hotmail.com");


        Estudiante_Apoyo estudiante_apoyo = new Estudiante_Apoyo();
        estudiante_apoyo.setEstudiante(estudiante);
        estudiante_apoyo.setActividadPA(actividadPA);

        ea.add(estudiante_apoyo);

        actividadPADao.createActividadPA(actividadPA, ea);
    }
}

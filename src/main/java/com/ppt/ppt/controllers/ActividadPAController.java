package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.ActividadPADao;
import com.ppt.ppt.dao.EstudianteDao;
import com.ppt.ppt.dao.ProyectoAulaDao;
import com.ppt.ppt.dao.UsuarioDao;
import com.ppt.ppt.models.ActividadPA;
import com.ppt.ppt.models.Estudiante;
import com.ppt.ppt.models.Estudiante_Apoyo;
import com.ppt.ppt.models.ProyectoAula;
import com.ppt.ppt.utils.JWTUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("apa")
public class ActividadPAController {

    @Autowired
    private ActividadPADao actividadPADao;

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private EstudianteDao estudianteDao;

    @Autowired
    private ProyectoAulaDao proyectoAulaDao;

    @Autowired
    private JWTUtil jwtUtil;

    //Funciona correctamente
    @RequestMapping(value = "api/actividadpa", method = RequestMethod.GET)
    public List<ActividadPA> getActividadPA(){ return actividadPADao.getActividadPA();}

    //Funciona correctamente, con validación de id
    @RequestMapping(value = "api/actividadpa/{id}", method = RequestMethod.GET)
    public ActividadPA getActividadPA(@PathVariable int id, HttpServletResponse response){

        if(actividadPADao.getActividadPA(id) == null){
            response.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        return actividadPADao.getActividadPA(id);
    }

    //Funciona, aplicación de excepcion para id no existente
    @RequestMapping(value = "api/actividadpa/{id}", method = RequestMethod.DELETE)
    public void deleteActividadPA(@RequestHeader(value = "Authorization") String token, HttpServletResponse response, @PathVariable int id){
        if (!validaToken(token)){
            response.setStatus(HttpStatus.FORBIDDEN.value());
        }else if(actividadPADao.getActividadPA(id) == null) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
        }else{
            actividadPADao.deleteActividadPA(id);
        }
    }

    //Funciona, aplicación de excepcion para id no existente
    @RequestMapping(value = "api/actividadpa/{id}", method = RequestMethod.PUT)
    public void updateActividadPA(@RequestHeader(value = "Authorization") String token, HttpServletResponse response, @RequestBody ActividadPA actividadPA, @PathVariable int id){
        if(!validaToken(token)){
            response.setStatus(HttpStatus.FORBIDDEN.value());
        }else if(actividadPADao.getActividadPAByIdPA(id) == null) {

            response.setStatus(HttpStatus.BAD_REQUEST.value());
        }else{
            actividadPADao.updateActividadPA(actividadPA, id);
        }
    }

    //Funcionando correctamente
    @RequestMapping(value = "api/actividadpa/{idPA}", method = RequestMethod.POST)
    public void createActividadPA(@RequestHeader(value = "Authorization") String token, HttpServletResponse response, @RequestBody ActividadPA actividadPA, @RequestBody List<Integer> estudiantes, @PathVariable int idPA) {
        if(!validaToken(token)){
            response.setStatus(HttpStatus.FORBIDDEN.value());
        }else {
            List<Estudiante> e = new ArrayList<>();
            for(Integer i: estudiantes){
                e.add(estudianteDao.getEstudianteById(i));
            }

            Set<Estudiante_Apoyo> ea = new HashSet<>();

            for(Estudiante student: e) {
                Estudiante_Apoyo estudiante_apoyo = new Estudiante_Apoyo();
                estudiante_apoyo.setEstudiante(student);
                estudiante_apoyo.setActividadPA(actividadPA);
                ea.add(estudiante_apoyo);
            }
            //Buscar Pa por id
            ProyectoAula proyect = proyectoAulaDao.getProyectoAula(idPA);
            actividadPA.setPa(proyect);

            proyectoAulaDao.cargarActividades(actividadPA);
            actividadPADao.createActividadPA(actividadPA, ea);
        }
    }

    private boolean validaToken(String token){
        int userId = Integer.parseInt(jwtUtil.getKey(token));
        return usuarioDao.esDocenteLider(userId);
    }
}

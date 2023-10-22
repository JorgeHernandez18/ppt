package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.ActividadPADao;
import com.ppt.ppt.dao.EstudianteDao;
import com.ppt.ppt.dao.ProyectoAulaDao;
import com.ppt.ppt.dao.UsuarioDao;
import com.ppt.ppt.dto.CrearActividadPA;
import com.ppt.ppt.models.*;
import com.ppt.ppt.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
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
    public ResponseEntity<List<ActividadPA>> getActividadPA(){ return ResponseEntity.ok(actividadPADao.getActividadPA());}

    //Funciona correctamente, con validación de id
    @RequestMapping(value = "api/actividadpa/{id}", method = RequestMethod.GET)
    public ResponseEntity<ActividadPA>  getActividadPA(@PathVariable int id){

        if(actividadPADao.getActividadPA(id) == null){
            throw new ErrorResponseException(HttpStatusCode.valueOf(404), new Exception("Actividad no existente"));
        }
        return ResponseEntity.ok(actividadPADao.getActividadPA(id));
    }

    //Funciona, aplicación de excepcion para id no existente
    @RequestMapping(value = "api/actividadpa/{id}", method = RequestMethod.DELETE)
    public void deleteActividadPA(@RequestHeader(value = "Authorization") String token, @RequestBody ActividadPA actividadPA){
        if (!validaToken(token)){
            new ErrorResponseException(HttpStatusCode.valueOf(401), new Exception("El usuario no es docente lider"));
        }else if(actividadPADao.getActividadPA(actividadPA.getId()) == null) {
            throw new ErrorResponseException(HttpStatusCode.valueOf(404), new Exception("Actividad no existente"));
        }else{
            proyectoAulaDao.eliminarActividades(actividadPA);
            actividadPADao.deleteActividadPA(actividadPA.getId());
        }
    }

    //Funciona, aplicación de excepcion para id no existente
    @RequestMapping(value = "api/actividadpa/{id}", method = RequestMethod.PUT)
    public void updateActividadPA(@RequestHeader(value = "Authorization") String token, @RequestBody ActividadPA actividadPA, @PathVariable int id){
        if(!validaToken(token)){
            new ErrorResponseException(HttpStatusCode.valueOf(401), new Exception("El usuario no es docente lider"));
        }else if(actividadPADao.getActividadPAByIdPA(id) == null) {
            throw new ErrorResponseException(HttpStatusCode.valueOf(404), new Exception("Actividad no existente"));
        }else{
            actividadPADao.updateActividadPA(actividadPA, id);
        }
    }

    //Funcionando correctamente
    @RequestMapping(value = "api/actividadpa/{idPA}", method = RequestMethod.POST)
    public void createActividadPA(@RequestHeader(value = "Authorization") String token, @RequestBody CrearActividadPA actividadDto, @PathVariable Integer idPA) {
        if(!validaToken(token)){
            new ErrorResponseException(HttpStatusCode.valueOf(401), new Exception("El usuario no es docente lider"));
        }else {
            List<Estudiante> e = new ArrayList<>();
            for(Integer i: actividadDto.getEstudiantes()){
                e.add(estudianteDao.getEstudianteById(i));
            }

            Set<Estudiante_Apoyo> ea = new HashSet<>();

            for(Estudiante student: e) {
                Estudiante_Apoyo estudiante_apoyo = new Estudiante_Apoyo();
                estudiante_apoyo.setEstudiante(student);
                estudiante_apoyo.setActividadPA(actividadDto.getActividadPA());
                ea.add(estudiante_apoyo);
            }

            actividadPADao.createActividadPA(actividadDto.getActividadPA(), ea, idPA);
        }
    }

    private boolean validaToken(String token){
        int userId = Integer.parseInt(jwtUtil.getKey(token));
        return usuarioDao.esDocenteLider(userId);
    }
}

package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.ProyectoAulaDao;
import com.ppt.ppt.dao.UsuarioDao;
import com.ppt.ppt.models.*;
import com.ppt.ppt.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pa")
public class ProyectoAulaController {


    @Autowired
    private ProyectoAulaDao proyectoAulaDao;

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    //Funciona correctamente
    @RequestMapping(value = "api/proyectoaula", method = RequestMethod.GET)
    public ResponseEntity<List<ProyectoAula>> getProyectoAula(){ return ResponseEntity.ok(proyectoAulaDao.getProyectoAula());}

    //Funciona correctamente, con control de id
    @RequestMapping(value = "api/proyectoaula/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProyectoAula> getProyectoAula(@PathVariable int id){
        if(proyectoAulaDao.getProyectoAula(id) == null){
            throw new ErrorResponseException(HttpStatusCode.valueOf(404), new Exception("Proyecto de aula no existente"));
        }
        return ResponseEntity.ok(proyectoAulaDao.getProyectoAula(id));
    }

    //Funciona correctamente, con control de id
    //No elimina por manejo de Foranea
    @RequestMapping(value = "api/proyectoaula/{id}", method = RequestMethod.DELETE)
    public void deleteProyectoAula(@RequestHeader(value = "Authorization") String token, @PathVariable int id){
        if(!validaToken(token)){
            throw new ErrorResponseException(HttpStatusCode.valueOf(401), new Exception("El usuario no es docente lider"));
        }else if(proyectoAulaDao.getProyectoAula(id) == null) {
            throw new ErrorResponseException(HttpStatusCode.valueOf(404), new Exception("Proyecto de aula no existente"));
        }else{
            proyectoAulaDao.deleteProyectoAula(id);
        }
    }

    //Funciona correctamente, con control de id
    @RequestMapping(value = "api/proyectoaula/{id}", method = RequestMethod.PUT)
    public void updateProyectoAula(@RequestHeader(value = "Authorization") String token, @RequestBody ProyectoAula proyectoAula,@PathVariable int id){
        if(!validaToken(token)){
            throw new ErrorResponseException(HttpStatusCode.valueOf(401), new Exception("El usuario no es docente lider"));
        }else if(proyectoAulaDao.getProyectoAula(id) == null) {
            throw new ErrorResponseException(HttpStatusCode.valueOf(404), new Exception("Proyecto de aula no existente"));
        }else{
            proyectoAulaDao.updateProyectoAula(proyectoAula, id);
        }
    }

    //Funciona correctamente
    @RequestMapping(value = "api/proyectoaula", method = RequestMethod.POST)
    public void createProyectoAula(@RequestHeader(value = "Authorization") String token, @RequestBody ProyectoAula proyectoAula) throws Exception {
        if (!validaToken(token)) {
            new ErrorResponseException(HttpStatusCode.valueOf(401), new Exception("El usuario no es docente lider"));
        } else {
                proyectoAulaDao.createProyectoAula(proyectoAula);
        }
    }

    //Lista las actividades de un proyecto de aula en especifico controlada por el id del proyecto de aula
    @RequestMapping(value = "api/actividadespa/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ActividadPA>>  listarActividadesDeCadaProyecto(@PathVariable Integer id){
        if(proyectoAulaDao.getProyectoAula(id) == null){
            throw new ErrorResponseException(HttpStatusCode.valueOf(404), new Exception("Proyecto de aula no existente"));
        }
        return ResponseEntity.ok(proyectoAulaDao.listarActividadesDeCadaProyecto(id));
    }

    private boolean validaToken(String token){
        System.out.println(jwtUtil.getKey(token));
        int userId = Integer.parseInt(jwtUtil.getKey(token));

        return usuarioDao.esDocenteLider(userId);
    }

}

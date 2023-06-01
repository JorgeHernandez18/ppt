package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.ProyectoAulaDao;
import com.ppt.ppt.dao.UsuarioDao;
import com.ppt.ppt.models.*;
import com.ppt.ppt.utils.JWTUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public List<ProyectoAula> getProyectoAula(){ return proyectoAulaDao.getProyectoAula();}

    //Funciona correctamente, sin control de id
    @RequestMapping(value = "api/proyectoaula/{id}", method = RequestMethod.GET)
    public ProyectoAula getProyectoAula(@PathVariable int id){
        return proyectoAulaDao.getProyectoAula(id);
    }

    //Funciona correctamente, sin control de id
    @RequestMapping(value = "api/proyectoaula/{id}", method = RequestMethod.DELETE)
    public void deleteProyectoAula(@RequestHeader(value = "Authorization") String token, HttpServletResponse response, @PathVariable int id){
        if(!validaToken(token)){
            response.setStatus(HttpStatus.FORBIDDEN.value());
        }else {
            proyectoAulaDao.deleteProyectoAula(id);
        }
    }

    //Funciona correctamente, sin control de id
    @RequestMapping(value = "api/proyectoaula/{id}", method = RequestMethod.PUT)
    public void updateProyectoAula(@RequestHeader(value = "Authorization") String token, HttpServletResponse response,@RequestBody ProyectoAula proyectoAula,@PathVariable int id){
        if(!validaToken(token)){
            response.setStatus(HttpStatus.FORBIDDEN.value());
        }else {
            proyectoAulaDao.updateProyectoAula(proyectoAula, id);
        }
    }

    //Funciona correctamente
    @RequestMapping(value = "api/proyectoaula", method = RequestMethod.POST)
    public void createProyectoAula(@RequestHeader(value = "Authorization") String token, HttpServletResponse response, @RequestBody ProyectoAula proyectoAula) {
        if (!validaToken(token)) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
        } else {
                proyectoAulaDao.createProyectoAula(proyectoAula);
        }
    }

    private boolean validaToken(String token){
        System.out.println(jwtUtil.getKey(token));
        int userId = Integer.parseInt(jwtUtil.getKey(token));

        return usuarioDao.esDocenteLider(userId);
    }

}

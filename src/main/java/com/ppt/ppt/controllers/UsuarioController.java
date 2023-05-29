package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.UsuarioDao;
import com.ppt.ppt.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuario/{id}")
    public Usuario getUsuario(@PathVariable String id){
        return usuarioDao.getUsuario(id);
    }

    @RequestMapping(value = "api/usuario", method = RequestMethod.POST)
    public void createUsuario(@RequestBody Usuario usuario){
        usuarioDao.createUsuario(usuario);
    }

}

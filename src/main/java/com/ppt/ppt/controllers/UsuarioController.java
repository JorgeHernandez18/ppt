package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.UsuarioDao;
import com.ppt.ppt.models.*;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    /*He decidido usar estos 3 metodos ya que servirá para ver los datos en "mi perfil" y poder actualizarlos o cambiarlos*/

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuario/{id}")
    public Usuario getUsuario(@PathVariable String id){
        return usuarioDao.getUsuario(id);
    }

    //Metodo usado para registrar un usuario
    @RequestMapping(value = "api/usuario/{rol}", method = RequestMethod.POST)
    public void createUsuario(@RequestBody Usuario usuario,@PathVariable int rol){
        Set<UsuarioRol> ur = new HashSet<>();

        Rol rolAux = new Rol();
        rolAux.setId(rol);


        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setRol(rolAux);
        usuarioRol.setUsuario(usuario);

        ur.add(usuarioRol);

        convertirPassword(usuario);
        usuarioDao.createUsuario(usuario, ur);


    }

    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.PUT)
    public void updateUsuario(@RequestBody Usuario usuario, @PathVariable String id){
        convertirPassword(usuario);
        usuarioDao.updateUsuario(usuario, id);
    }

    private void convertirPassword(Usuario usuario){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword().toCharArray());
        usuario.setPassword(hash);
    }

}

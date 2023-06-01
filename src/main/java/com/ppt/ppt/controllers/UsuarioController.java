package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.UsuarioDao;
import com.ppt.ppt.models.*;
import com.ppt.ppt.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    /*He decidido usar estos 3 metodos ya que servirá para ver los datos en "mi perfil" y poder actualizarlos o cambiarlos*/

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    //Testeado y funcionando correctamente
    @RequestMapping(value = "api/usuario/{correo}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable String correo) throws Exception {
        return usuarioDao.getUsuario(correo);
    }

    //Metodo usado para registrar un usuario
    @RequestMapping(value = "api/usuario/{rol}", method = RequestMethod.POST)
    public void createUsuario(@RequestBody Usuario usuario, @PathVariable int rol) throws Exception {
        Usuario u = usuarioDao.getUsuario(usuario.getCorreo_electronico());
        if (u != null) {
            throw new Exception("Email de usuario existente");
        } else {

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
    }

    //Funcionando correctamente
    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.PUT)
    public void updateUsuario(@RequestHeader(value = "Authorization") String token, @RequestBody Usuario usuario, @PathVariable String id) {

        String idUsuario = jwtUtil.getKey(token);
        if(idUsuario == null){
            return;
        }else {
            convertirPassword(usuario);
            usuarioDao.updateUsuario(usuario, id);
        }
    }

    //Funcionando correctamente
    @RequestMapping(value = "api/docentes_apoyo", method = RequestMethod.GET)
    public List<Usuario> docentesApoyo() throws Exception {return usuarioDao.docentesApoyo();}

    //Funcionando correctamente
    @RequestMapping(value = "api/docentes_lider", method = RequestMethod.GET)
    public List<Usuario> docentesLider() throws Exception {return usuarioDao.docentesLider();}

    @RequestMapping(value = "api/es_docente/{id}", method = RequestMethod.GET)
    public boolean esDocente(@PathVariable int id){return usuarioDao.esDocente(id);}

    @RequestMapping(value = "api/es_docente_lider/{id}", method = RequestMethod.GET)
    public boolean esDocenteLider(@PathVariable int id){return usuarioDao.esDocenteLider(id);}

    //Funcionando correctamente
    private void convertirPassword(Usuario usuario) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword().toCharArray());
        usuario.setPassword(hash);
    }
}

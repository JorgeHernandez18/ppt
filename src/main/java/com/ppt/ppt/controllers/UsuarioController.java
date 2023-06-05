package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.UsuarioDao;
import com.ppt.ppt.models.*;
import com.ppt.ppt.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    /*He decidido usar estos 3 metodos ya que servirá para ver los datos en "mi perfil" y poder actualizarlos o cambiarlos*/

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> getUsuarios() {
        return ResponseEntity.ok(usuarioDao.getUsuarios());
    }

    //Testeado y funcionando correctamente
    @RequestMapping(value = "api/usuario/{correo}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> getUsuario(@PathVariable String correo) throws Exception {
        if(usuarioDao.getUsuario(correo) == null){
            throw new ErrorResponseException(HttpStatusCode.valueOf(404), new Exception("Usuario no existente"));
        }
            return ResponseEntity.ok(usuarioDao.getUsuario(correo));
    }

    //Metodo usado para registrar un usuario
    @RequestMapping(value = "api/usuario/{rol}", method = RequestMethod.POST)
    public void createUsuario(@RequestBody Usuario usuario, @PathVariable int rol) throws Exception {
        Usuario u = usuarioDao.getUsuario(usuario.getCorreo_electronico());
        if (u != null) {
            throw new ErrorResponseException(HttpStatusCode.valueOf(400), new Exception("Usuario existente"));
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
    public void updateUsuario(@RequestHeader(value = "Authorization") String token, @RequestBody Usuario usuario, @PathVariable int id, HttpServletResponse response) {

        String idUsuario = jwtUtil.getKey(token);
        if(idUsuario == null){
            throw new ErrorResponseException(HttpStatusCode.valueOf(404), new Exception("Usuario no existente"));
        }else {
            convertirPassword(usuario);
            usuarioDao.updateUsuario(usuario, id);
        }
    }

    //Funcionando correctamente
    @RequestMapping(value = "api/docentes_apoyo", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> docentesApoyo() throws Exception {return ResponseEntity.ok(usuarioDao.docentesApoyo());}

    //Funcionando correctamente
    @RequestMapping(value = "api/docentes_lider", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> docentesLider() throws Exception {return ResponseEntity.ok(usuarioDao.docentesLider());}

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

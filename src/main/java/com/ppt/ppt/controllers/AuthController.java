package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.UsuarioDao;
import com.ppt.ppt.models.Token;
import com.ppt.ppt.models.Usuario;
import com.ppt.ppt.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    //Funcionando correctamente
    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public ResponseEntity<Token> login(@RequestBody Usuario usuario) throws Exception{
        Usuario usuarioLog = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
        if(usuarioLog != null) {
            System.out.println(usuarioLog.getId() + usuarioLog.getCorreo_electronico());
            System.out.println(jwtUtil.create(String.valueOf(usuarioLog.getId()), usuarioLog.getCorreo_electronico()));
            return ResponseEntity.ok(new Token(jwtUtil.create(String.valueOf(usuarioLog.getId()), usuarioLog.getCorreo_electronico())));
        }

        throw new ErrorResponseException(HttpStatusCode.valueOf(400), new Exception("Usuario o contrasenia incorrectos"));
    }
}

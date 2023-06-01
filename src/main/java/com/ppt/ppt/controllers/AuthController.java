package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.UsuarioDao;
import com.ppt.ppt.models.Usuario;
import com.ppt.ppt.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;
    
    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) throws Exception{
        Usuario usuarioLog = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
        if(usuarioLog != null) {
            return jwtUtil.create(String.valueOf(usuarioLog.getId()), usuarioLog.getCorreo_electronico());
        }
        return "Correo o contraseña incorrecto";
    }
}

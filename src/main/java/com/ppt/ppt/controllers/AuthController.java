package com.ppt.ppt.controllers;

import com.ppt.ppt.dao.UsuarioDao;
import com.ppt.ppt.models.Usuario;
import com.ppt.ppt.utils.JWTUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public String login(@RequestBody Usuario usuario, HttpServletResponse response) throws Exception{
        Usuario usuarioLog = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
        if(usuarioLog != null) {
            System.out.println(usuarioLog.getId() + usuarioLog.getCorreo_electronico());
            System.out.println(jwtUtil.create(String.valueOf(usuarioLog.getId()), usuarioLog.getCorreo_electronico()));
            return jwtUtil.create(String.valueOf(usuarioLog.getId()), usuarioLog.getCorreo_electronico());
        }

        response.setStatus(HttpStatus.BAD_REQUEST.value());

        return "Correo o contraseña incorrecto";
    }
}

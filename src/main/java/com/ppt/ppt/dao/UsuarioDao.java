package com.ppt.ppt.dao;

import com.ppt.ppt.models.Usuario;
import com.ppt.ppt.models.UsuarioRol;

import java.util.Set;

public interface UsuarioDao {

    Usuario getUsuario(String correo);

    void createUsuario(Usuario usuario, Set<UsuarioRol> ur);

    void updateUsuario(Usuario usuario, String id);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}

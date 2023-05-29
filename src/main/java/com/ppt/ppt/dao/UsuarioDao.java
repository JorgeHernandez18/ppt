package com.ppt.ppt.dao;

import com.ppt.ppt.models.Usuario;

public interface UsuarioDao {

    Usuario getUsuario(String id);

    void createUsuario(Usuario usuario);
}

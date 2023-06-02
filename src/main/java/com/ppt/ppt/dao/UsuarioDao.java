package com.ppt.ppt.dao;

import com.ppt.ppt.models.Usuario;
import com.ppt.ppt.models.UsuarioRol;

import java.util.List;
import java.util.Set;

public interface UsuarioDao {

    List<Usuario> getUsuarios();

    Usuario getUsuario(String correo) throws Exception;

    void createUsuario(Usuario usuario, Set<UsuarioRol> ur);

    void updateUsuario(Usuario usuario, int id);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);

    boolean esDocente(int id);

    boolean esDocenteLider(int id);

    List<Usuario> docentesApoyo();

    List<Usuario> docentesLider();
}

package com.ppt.ppt.dao;

import com.ppt.ppt.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Usuario getUsuario(String id) {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public void createUsuario(Usuario usuario) {
        entityManager.merge(usuario);
    }
}

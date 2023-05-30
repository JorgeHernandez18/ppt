package com.ppt.ppt.dao;

import com.ppt.ppt.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public void updateUsuario(Usuario usuario, String id) {
        Usuario u = entityManager.find(Usuario.class, id);
        u.setNombre(usuario.getNombre());
        u.setApellido(usuario.getApellido());
        u.setNumeroTelefono(usuario.getNumeroTelefono());
        u.setCorreoElectronico(usuario.getCorreoElectronico());

        entityManager.merge(u);
    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {
        String query = "FROM Usuario WHERE correoElectronico = :correoElectronico";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("correoElectronico", usuario.getCorreoElectronico())
                .getResultList();
        if(lista.isEmpty()){
            return null;
        }

        String passwordHashed = lista.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        if(argon2.verify(passwordHashed, usuario.getPassword())){
            return lista.get(0);
        }
        return null;
    }
}

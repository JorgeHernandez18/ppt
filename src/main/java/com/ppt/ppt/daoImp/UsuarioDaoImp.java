package com.ppt.ppt.daoImp;

import com.ppt.ppt.dao.UsuarioDao;
import com.ppt.ppt.models.Estudiante;
import com.ppt.ppt.models.Usuario;
import com.ppt.ppt.models.UsuarioRol;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Usuario getUsuario(String correo) throws Exception{

        try {
            String query = "FROM Usuario WHERE correo_electronico = :correo";
            Usuario u = (Usuario) entityManager.createQuery(query)
                    .setParameter("correo", correo)
                    .getSingleResult();

            return u;
        }catch (NoResultException e){

            return null;
        }
    }

    @Override
    public void createUsuario(Usuario usuario, Set<UsuarioRol> ur) {
        for(UsuarioRol usuarioRol: ur){
            entityManager.merge(usuarioRol.getRol());
        }
        usuario.getUsuarioRoles().addAll(ur);

        entityManager.merge(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario, String id) {
        Usuario u = entityManager.find(Usuario.class, id);
        u.setNombre(usuario.getNombre());
        u.setApellido(usuario.getApellido());
        u.setNumero_telefono(usuario.getNumero_telefono());
        u.setCorreo_electronico(usuario.getCorreo_electronico());
        u.setPassword(usuario.getPassword());

        entityManager.merge(u);
    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {
        String query = "FROM Usuario WHERE correo_electronico = :correo_electronico";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("correo_electronico", usuario.getCorreo_electronico())
                .getResultList();
        if(lista.isEmpty()){
            return null;
        }

        String passwordHashed = lista.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        if(argon2.verify(passwordHashed, usuario.getPassword().toCharArray())){
            return lista.get(0);
        }
        return null;
    }

    @Override
    public boolean esDocente(Usuario usuario) {
        Set<UsuarioRol> ur = new HashSet<>();
        ur = usuario.getUsuarioRoles();

        for(UsuarioRol usuarioRol: ur){
            if(usuarioRol.getRol().equals(2))
                return true;
        }

        return false;
    }

    @Override
    public List<Usuario> docentesApoyo() {

        String query = "FROM UsuarioRol";
        List<UsuarioRol> usuarioRoles = entityManager.createQuery(query).getResultList();
        List<Usuario> docentes = new ArrayList<>();
        for(UsuarioRol ur: usuarioRoles){
            if(ur.getRol().getId() == 2){
                Usuario u = entityManager.find(Usuario.class, ur.getUsuario().getId());
                docentes.add(u);
            }
        }
        if(!docentes.isEmpty()){
            return docentes;
        }
        return null;
    }
}

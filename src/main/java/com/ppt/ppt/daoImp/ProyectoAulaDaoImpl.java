package com.ppt.ppt.daoImp;

import com.ppt.ppt.dao.ProyectoAulaDao;
import com.ppt.ppt.models.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
@Primary
public class ProyectoAulaDaoImpl implements ProyectoAulaDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<ProyectoAula> getProyectoAula() {
        String query ="FROM ProyectoAula";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public ProyectoAula getProyectoAula(int id) {
        return entityManager.find(ProyectoAula.class, id);
    }

    @Override
    public void deleteProyectoAula(int id) {
        ProyectoAula pa = entityManager.find(ProyectoAula.class, id);
        entityManager.remove(pa);
    }

    @Override
    public void updateProyectoAula(ProyectoAula proyectoAula, int id) {
        ProyectoAula pa = entityManager.find(ProyectoAula.class, id);
        pa.setNombre(proyectoAula.getNombre());
        pa.setId_eje_transversal(proyectoAula.getId_eje_transversal());
        pa.setTipo_eje(proyectoAula.getTipo_eje());
        pa.setFecha_inicio(proyectoAula.getFecha_inicio());
        pa.setFecha_fin(proyectoAula.getFecha_fin());
        pa.setDocente_lider(proyectoAula.getDocente_lider());
        pa.setGrado(proyectoAula.getGrado());
        pa.setCierre(proyectoAula.getCierre());

        entityManager.merge(pa);

    }

    @Override
    public void createProyectoAula(ProyectoAula proyectoAula) {
        entityManager.merge(proyectoAula);
    }

    @Override
    public void cargarActividades(ActividadPA actividad) {
        ProyectoAula pa = entityManager.find(ProyectoAula.class, actividad.getPa().getId());

        pa.setActividades((Set<ActividadPA>) actividad);
    }

    @Override
    public void eliminarActividades(ActividadPA actividad) {
        ProyectoAula pa = entityManager.find(ProyectoAula.class, actividad.getPa().getId());

        for(ActividadPA a: pa.getActividades()){
            if(actividad.getId() == a.getId())
                pa.getActividades().remove(a);
        }
    }

    @Override
    public List<ActividadPA> listarActividadesDeCadaProyecto(int id) {
        ProyectoAula pa = entityManager.find(ProyectoAula.class, id);
        Set<ActividadPA> actividades = pa.getActividades();
        List<ActividadPA> actividadesPA= new ArrayList<>();
        for(ActividadPA a: actividades){
            if(pa.getId() == a.getPa().getId())
            {
                actividadesPA.add(a);
            }
        }
        return actividadesPA;
    }
}

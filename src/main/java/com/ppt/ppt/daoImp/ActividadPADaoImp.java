package com.ppt.ppt.daoImp;

import com.ppt.ppt.dao.ActividadPADao;
import com.ppt.ppt.models.*;
import com.ppt.ppt.repository.ActividadPARepository;
import com.ppt.ppt.repository.EstudianteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class ActividadPADaoImp implements ActividadPADao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    ActividadPARepository actividadPARepository;

    @Autowired
    EstudianteRepository estudianteRepository;


    @Override
    @Transactional
    public List<ActividadPA> getActividadPA() {
        String query ="FROM ActividadPA";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<ActividadPA> getActividadPAByIdPA(int id) {
        /*String query = "FROM ProyectoAula";
        List<ProyectoAula> proyectos = entityManager.createQuery(query).getResultList();
        List<ActividadPA> actividades = new ArrayList<>();
        for(ProyectoAula pa: proyectos){
            if(pa.getId() == id){
                actividades.add(pa.getActividades());
                docentes.add(u);
            }
        }
        if(!docentes.isEmpty()){
            return docentes;
        }*/
        return null;
    }

    @Override
    public ActividadPA getActividadPA(int id) {
        return entityManager.find(ActividadPA.class, id);
    }

    @Override
    public void deleteActividadPA(int id) {
        ActividadPA apa = entityManager.find(ActividadPA.class, id);
        entityManager.remove(apa);
    }

    @Override
    public void updateActividadPA(ActividadPA actividadPA, int id) {
        ActividadPA apa = entityManager.find(ActividadPA.class, id);
        apa.setNombre(actividadPA.getNombre());
        apa.setFecha_inicio(actividadPA.getFecha_inicio());
        apa.setFecha_fin(actividadPA.getFecha_fin());
        apa.setCumplimiento(actividadPA.getCumplimiento());
        apa.setObservacion(actividadPA.getObservacion());
        apa.setPa(actividadPA.getPa());

        entityManager.merge(apa);
    }

    /*
    * Primero persistir ProyectoAula y luego persistir actividadPA para guardar los estudiantes_apoyo.
    *
    * Al crear la actividadPA o actividadPT, debo persistir o realizar el entityManager.merge(proyectoAula), entityManager.mergeplanTrabajo)
    * */
    @Override
    public void createActividadPA(ActividadPA actividadPA, Set<Estudiante_Apoyo> ea, Integer id) {

        ProyectoAula pa = entityManager.find(ProyectoAula.class, id);
        actividadPA.setPa(pa);
        pa.getActividades().add(actividadPA);

        for (Estudiante_Apoyo estudiante_apoyo: ea){
            entityManager.merge(estudiante_apoyo.getEstudiante());
        }
        actividadPA.getEa().addAll(ea);

        entityManager.merge(actividadPA);
    }


}

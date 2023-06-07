package com.ppt.ppt.dao;

import com.ppt.ppt.models.ActividadPA;
import com.ppt.ppt.models.Estudiante_Apoyo;

import java.util.List;
import java.util.Set;

public interface ActividadPADao {

    List<ActividadPA> getActividadPA();

    List<ActividadPA> getActividadPAByIdPA(int id);

    ActividadPA getActividadPA(int id);

    void deleteActividadPA(int id);

    void updateActividadPA(ActividadPA actividadPA, int id);

    void createActividadPA(ActividadPA actividadPA, Set<Estudiante_Apoyo> ea, Integer id);


}

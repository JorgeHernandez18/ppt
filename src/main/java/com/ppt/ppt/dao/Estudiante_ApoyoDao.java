package com.ppt.ppt.dao;

import com.ppt.ppt.models.Estudiante;
import com.ppt.ppt.models.Estudiante_Apoyo;

import java.util.List;

public interface Estudiante_ApoyoDao {

    List<Estudiante_Apoyo> getEstudiante_Apoyo();
    void seleccionarEstudianteApoyo(List<Estudiante> e);

}

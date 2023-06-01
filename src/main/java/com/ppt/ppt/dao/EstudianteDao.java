package com.ppt.ppt.dao;


import com.ppt.ppt.models.Estudiante;

import java.util.List;

public interface EstudianteDao {

    List<Estudiante> getEstudiante();

    Estudiante getEstudiante(String correo);

    void createEstudiante(Estudiante estudiante);


}

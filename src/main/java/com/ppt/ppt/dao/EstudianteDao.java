package com.ppt.ppt.dao;


import com.ppt.ppt.models.Estudiante;

import java.util.List;

public interface EstudianteDao {

    List<Estudiante> getEstudiantes(String q);

    Estudiante getEstudiante(String correo) throws Exception;

    void createEstudiante(Estudiante estudiante);

    Estudiante getEstudianteById(int id);


}

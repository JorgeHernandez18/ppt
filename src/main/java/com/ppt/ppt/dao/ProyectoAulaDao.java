package com.ppt.ppt.dao;

import com.ppt.ppt.models.ProyectoAula;

import java.util.List;

public interface ProyectoAulaDao {
    List<ProyectoAula> getProyectoAula();

    ProyectoAula getProyectoAula(int id);

    void deleteProyectoAula(int id);

    void updateProyectoAula(ProyectoAula proyectoAula, int id);

    void createProyectoAula(ProyectoAula proyectoAula);
}

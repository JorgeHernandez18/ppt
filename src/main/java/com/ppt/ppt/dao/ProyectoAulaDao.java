package com.ppt.ppt.dao;

import com.ppt.ppt.models.ActividadPA;
import com.ppt.ppt.models.ActividadPT;
import com.ppt.ppt.models.ProyectoAula;

import java.util.List;
import java.util.Set;

public interface ProyectoAulaDao {
    List<ProyectoAula> getProyectoAula();

    ProyectoAula getProyectoAula(int id);

    void deleteProyectoAula(int id);

    void updateProyectoAula(ProyectoAula proyectoAula, int id);

    void createProyectoAula(ProyectoAula proyectoAula);

    void cargarActividades(ActividadPA actividad);

    void eliminarActividades(ActividadPA actividad);

    List<ActividadPA> listarActividadesDeCadaProyecto(Integer id);
}

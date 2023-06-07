package com.ppt.ppt.dao;

import com.ppt.ppt.models.ActividadPT;

import java.util.List;

public interface ActividadPTDao {

    List<ActividadPT> getActividadPT();

    ActividadPT getActividadPT(Integer id);

    void deleteActividadPT(int id);

    void updateActividadPT(ActividadPT actividadPT, int id);

    void createActividadPT(ActividadPT actividadPT, Integer id);
}

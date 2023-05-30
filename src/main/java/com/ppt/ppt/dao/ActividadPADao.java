package com.ppt.ppt.dao;

import com.ppt.ppt.models.ActividadPA;

import java.util.List;

public interface ActividadPADao {

    List<ActividadPA> getActividadPA();

    ActividadPA getActividadPA(int id);

    void deleteActividadPA(int id);

    void updateActividadPA(ActividadPA actividadPA, int id);

    void createActividadPA(ActividadPA actividadPA);


}

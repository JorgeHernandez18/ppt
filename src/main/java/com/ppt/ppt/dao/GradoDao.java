package com.ppt.ppt.dao;

import com.ppt.ppt.models.Grado;
import java.util.List;

public interface GradoDao {

    List<Grado> getGrado();

    Grado getGrado(int id);

    void createGrado(Grado grado);
}

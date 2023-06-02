package com.ppt.ppt.dao;

import com.ppt.ppt.models.TipoEjeTransversal;

import java.util.List;

public interface TipoEjeTransversalDao {

    List<TipoEjeTransversal> getTipoEjeTransversal();

    TipoEjeTransversal getTipoEjeTransversal(int id);

    List<TipoEjeTransversal> getTipoEjeTransversalByEje(int id);
}

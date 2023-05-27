package com.ppt.ppt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PlanTrabajo")
public class PlanTrabajo {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "anio")
    private String anio;

    @Column(name = "id_eje_transversal")
    private int id_eje_transversal;

    @Column(name = "actividad_pt")
    private int actividad_pt;

    @Column(name = "cierre")
    private String cierre;
}

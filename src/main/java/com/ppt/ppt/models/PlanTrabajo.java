package com.ppt.ppt.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "plan_trabajo")
public class PlanTrabajo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

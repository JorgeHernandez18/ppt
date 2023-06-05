package com.ppt.ppt.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "actividad_pt")
public class ActividadPT {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha_inicio")
    private String fecha_inicio;

    @Column(name = "fecha_fin")
    private String fecha_fin;

    //Tengo un metodo en usuarioController para listar todos los docentes de apoyo.
    @Column(name = "docente_apoyo")
    private int docente_apoyo;

    @Column(name = "cumplimiento")
    private byte cumplimiento;

    @Column(name = "observacion")
    private String observacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plantrabajo")
    private PlanTrabajo pt;
}

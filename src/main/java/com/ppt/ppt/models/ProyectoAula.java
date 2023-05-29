package com.ppt.ppt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "proyecto_aula")
public class ProyectoAula {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "id_eje_transversal")
    private int id_eje_transversal;

    @Column(name = "tipo_eje")
    private String tipo_eje;

    @Column(name = "fecha_inicio")
    private String fecha_inicio;

    @Column(name = "fecha_fin")
    private String fecha_fin;

    @Column(name = "docente_lider")
    private int docente_lider;

    @Column(name = "actividad_pa")
    private int actividad_pa;

    @Column(name = "grado")
    private int grado;

    @Column(name = "cierre")
    private String cierre;
}

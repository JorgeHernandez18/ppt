package com.ppt.ppt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "herramienta")
public class Herramienta {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "id_creador")
    private String id_creador;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "poblacion")
    private String poblacion;

    @Column(name = "tema")
    private String tema;

    @Column(name = "objetivos")
    private String objetivos;

    @Column(name = "id_eje_transversal")
    private int id_eje_transversal;

    @Column(name = "primer_momento")
    private String primer_momento;

    @Column(name = "segundo_momento")
    private String segundo_momento;

    @Column(name = "tercer_momento")
    private String tercer_momento;

    @Column(name = "duracion")
    private String duracion;

    @Column(name = "recomendaciones")
    private String recomendaciones;

    @Column(name = "proceso_id")
    private int proceso_id;
}

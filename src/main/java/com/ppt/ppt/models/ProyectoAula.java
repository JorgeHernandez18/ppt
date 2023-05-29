package com.ppt.ppt.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "proyecto_aula")
public class ProyectoAula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "id_eje_transversal")
    private int id_eje_transversal;

    @Column(name = "tipo_eje")
    private int tipo_eje;

    @Column(name = "fecha_inicio")
    private String fecha_inicio;

    @Column(name = "fecha_fin")
    private String fecha_fin;

    @Column(name = "docente_lider")
    private int docente_lider;

    @Column(name = "grado")
    private int grado;

    @Column(name = "cierre")
    private String cierre;
}

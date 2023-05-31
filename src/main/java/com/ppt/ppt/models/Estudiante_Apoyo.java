package com.ppt.ppt.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "estudiante_apoyo")
public class Estudiante_Apoyo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "id_estudiante")
    private int id_estudiante;

    @Column(name = "id_actividadPA")
    private int id_actividadPA;
}

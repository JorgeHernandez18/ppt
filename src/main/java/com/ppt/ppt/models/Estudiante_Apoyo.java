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

    @ManyToOne(fetch = FetchType.EAGER)
    private Estudiante id_estudiante;

    @ManyToOne
    private ActividadPA id_actividadPA;
}

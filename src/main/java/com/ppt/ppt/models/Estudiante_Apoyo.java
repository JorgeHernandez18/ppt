package com.ppt.ppt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Estudiante_Apoyo")
public class Estudiante_Apoyo {

    @Column(name = "id_estudiante")
    private int id_estudiante;

    @Column(name = "id_actividadPA")
    private int id_actividadPA;
}

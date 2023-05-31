package com.ppt.ppt.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "actividad_pa")
public class ActividadPA {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha_inicio")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_inicio;

    @Column(name = "fecha_fin")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_fin;

    @Column(name = "estudiante")
    private int estudiante;

    @Column(name = "cumplimiento")
    private byte cumplimiento;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "proyecto_aula")
    private int proyecto_aula;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "id_actividadPA")
    private Set<Estudiante_Apoyo> ea = new HashSet<>();
}

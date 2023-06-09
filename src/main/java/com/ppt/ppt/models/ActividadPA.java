package com.ppt.ppt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
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
    private String fecha_inicio;

    @Column(name = "fecha_fin")
    private String fecha_fin;

    @Column(name = "cumplimiento")
    private byte cumplimiento;

    @Column(name = "observacion")
    private String observacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proyecto")
    private ProyectoAula pa;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "actividadPA")
    private Set<Estudiante_Apoyo> ea = new HashSet<>();
}

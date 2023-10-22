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
@Table(name = "plan_trabajo")
public class PlanTrabajo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "anio")
    private String anio;

    //Metodo que retorna los ejes transversales para obtener id acá
    @Column(name = "id_eje_transversal")
    private int id_eje_transversal;

    @Column(name = "cierre")
    private String cierre;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pt")
    private Set<ActividadPT> actividades = new HashSet<>();
}

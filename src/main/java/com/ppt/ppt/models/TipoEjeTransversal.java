package com.ppt.ppt.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TipoEjeTransversal")
public class TipoEjeTransversal {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_eje_transversal")
    private int id_eje_transversal;

    @Column(name = "descripcion")
    private String descripcion;
}

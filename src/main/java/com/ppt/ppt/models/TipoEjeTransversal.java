package com.ppt.ppt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TipoEjeTransversal")
public class TipoEjeTransversal {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "id_eje_transversal")
    private int id_eje_transversal;

    @Column(name = "descripcion")
    private String descripcion;
}

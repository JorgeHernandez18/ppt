package com.ppt.ppt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Rol")
public class Rol {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "descripcion")
    private String descripcion;
}

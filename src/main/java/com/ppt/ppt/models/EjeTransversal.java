package com.ppt.ppt.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "EjeTransversal")
public class EjeTransversal {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;
}

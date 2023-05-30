package com.ppt.ppt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "contenidoxherramienta")
public class ContenidoxHerramienta {


    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "id_herramienta")
    private int id_herramienta;

    @Column(name = "id_contenido")
    private int id_contenido;
}

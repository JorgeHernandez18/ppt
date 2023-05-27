package com.ppt.ppt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ContenidoxHerramienta")
public class ContenidoxHerramienta {

    @Column(name = "id_herramienta")
    private int id_herramienta;

    @Column(name = "id_contenido")
    private int id_contenido;
}

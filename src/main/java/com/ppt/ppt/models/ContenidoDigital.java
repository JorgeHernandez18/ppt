package com.ppt.ppt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ContenidoDigital")
public class ContenidoDigital {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "url")
    private String url;

    @Column(name = "id_usuario")
    private String id_usuario;

    @Column(name = "id_herramienta")
    private int id_herramienta;
}

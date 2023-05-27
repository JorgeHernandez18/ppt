package com.ppt.ppt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Docente")
public class Docente {

    @Id
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "cedulaD")
    private String cedulaD;
}

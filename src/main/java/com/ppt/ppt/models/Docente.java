package com.ppt.ppt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "docente")
public class Docente extends Usuario{

    @Column(name = "codigo", unique = true)
    private int codigo;

    @Column(name = "cedulaD")
    private String cedulaD;

    public Docente(){
        super();
    }
}

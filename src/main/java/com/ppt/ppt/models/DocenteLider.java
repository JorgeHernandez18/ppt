package com.ppt.ppt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "docente_lider")
public class DocenteLider extends Usuario{

    @Column(name = "codigo", unique = true)
    private int codigo;

    @Column(name = "eje_transversal")
    private int eje_transversal;

    @Column(name = "cedulaDL")
    private String cedulaDL;

    public DocenteLider(){
        super();
    }

}

package com.ppt.ppt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Grado")
public class Grado {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "titular")
    private String titular;
}

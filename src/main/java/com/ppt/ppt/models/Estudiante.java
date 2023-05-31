package com.ppt.ppt.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "correoElectronico")
    private String correoElectronico;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "id_estudiante")
    private Set<Estudiante_Apoyo> ea = new HashSet<>();

}

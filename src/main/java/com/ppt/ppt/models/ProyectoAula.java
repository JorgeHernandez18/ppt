package com.ppt.ppt.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@Table(name = "proyecto_aula")
public class ProyectoAula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    //Metodo que retorna los ejes transversales para obtener id acá
    @Column(name = "id_eje_transversal")
    private int id_eje_transversal;

    //Metodo que retorna tipos de eje para obtener el id acá
    @Column(name = "tipo_eje")
    private int tipo_eje;

    @Column(name = "fecha_inicio")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_inicio;

    @Column(name = "fecha_fin")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_fin;

    //En usuario controller tengo metodo para listar docentes_lider para guardar el id acá
    @Column(name = "docente_lider")
    private int docente_lider;

    //Metodo que retorna la lista de los grados para guardar el id acá
    @Column(name = "grado")
    private int grado;

    @Column(name = "cierre")
    private String cierre;
}

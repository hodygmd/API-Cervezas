package com.example.apicervezas.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cerveza")
public class Cerveza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca id_marca;
    @ManyToOne
    @JoinColumn(name = "id_contenido")
    private Contenido id_contenido;
    @Column(name = "status")
    private Byte status;
}

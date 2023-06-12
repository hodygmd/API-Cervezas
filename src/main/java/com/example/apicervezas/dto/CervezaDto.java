package com.example.apicervezas.dto;

import lombok.Data;

@Data
public class CervezaDto {
    private String nombre;
    private String descripcion;
    private Integer id_marca;
    private Integer id_contenido;
    private Byte status;
}

package com.example.apicervezas.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class MarcaDto {
    private String nombre;
    private String descripcion;
    private Byte status;
}

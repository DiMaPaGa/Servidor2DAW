package com.vedruna.rest1n.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JugadorCreationDTO {
    private String nombre;
    private int edad;
    private String nombreEquipo;
}

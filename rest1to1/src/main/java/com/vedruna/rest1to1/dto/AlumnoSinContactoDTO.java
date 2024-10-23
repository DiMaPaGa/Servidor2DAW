package com.vedruna.rest1to1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoSinContactoDTO {
    private Integer id; 
    private String nombre;
    private String apellidos;
}

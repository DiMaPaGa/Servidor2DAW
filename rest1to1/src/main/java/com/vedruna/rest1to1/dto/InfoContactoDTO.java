package com.vedruna.rest1to1.dto;

import com.vedruna.rest1to1.persistance.models.InfoContacto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoContactoDTO {
    private int id; // Cambiar a Integer según el tipo en la base de datos
    private String direccion;
    private int telefono;
   

    public InfoContactoDTO(InfoContacto infoContacto) {
        this.id = infoContacto.getId(); // Cambia según el nombre del método en tu entidad
        this.telefono = infoContacto.getTelefono(); // Cambia según el nombre del método en tu entidad
        this.direccion = infoContacto.getDireccion(); // Cambia según el nombre del método en tu entidad
    }
}

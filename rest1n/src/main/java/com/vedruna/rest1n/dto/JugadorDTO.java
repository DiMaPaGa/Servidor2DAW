package com.vedruna.rest1n.dto;

import com.vedruna.rest1n.persistance.models.Jugador;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JugadorDTO {

    private Integer id;
    private String nombre;
    private int edad;
    private String nombreEquipo;

    public JugadorDTO(Jugador jugador) {
        this.id = jugador.getId();
        this.nombre = jugador.getNombre();
        this.edad = jugador.getEdad();
        this.nombreEquipo = (jugador.getEquipo() != null) ? jugador.getEquipo().getNombre() : "Sin equipo";
    }
}
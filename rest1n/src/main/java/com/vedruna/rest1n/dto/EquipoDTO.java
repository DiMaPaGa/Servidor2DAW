package com.vedruna.rest1n.dto;

import java.util.ArrayList;
import java.util.List;

import com.vedruna.rest1n.persistance.models.Equipo;
import com.vedruna.rest1n.persistance.models.Jugador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor


public class EquipoDTO {
    private Integer id;
    private String nombre;
    List<String> nombresJugadores;
    

    // Constructor que convierte la entidad Equipo a EquipoDTO
    public EquipoDTO(Equipo equipo) {
        this.id = equipo.getId();
        this.nombre = equipo.getNombre();
        this.nombresJugadores = new ArrayList<>();
        
        // Recorremos los jugadores del equipo y extraemos solo los nombres
        for (Jugador jugador : equipo.getJugadores()) {
            this.nombresJugadores.add(jugador.getNombre());
        }
    }

}

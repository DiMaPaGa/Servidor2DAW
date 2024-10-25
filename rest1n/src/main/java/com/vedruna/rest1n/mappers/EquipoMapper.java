package com.vedruna.rest1n.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.vedruna.rest1n.dto.EquipoDTO;
import com.vedruna.rest1n.persistance.models.Equipo;
import com.vedruna.rest1n.persistance.models.Jugador;


@Component

public class EquipoMapper {


   // Método para convertir de Entidad Equipo a DTO Equipo
    public EquipoDTO toDTO(Equipo equipo) {
        EquipoDTO equipoDTO = new EquipoDTO();
        equipoDTO.setId(equipo.getId());
        equipoDTO.setNombre(equipo.getNombre());
        
        List<String> nombresJugadores = new ArrayList<>();
        for (Jugador jugador : equipo.getJugadores()) {
            nombresJugadores.add(jugador.getNombre());
        }
        
        equipoDTO.setNombresJugadores(nombresJugadores);
        return equipoDTO;
    }

    // Método para convertir de DTO Equipo a Entidad Equipo (sin jugadores)
    public Equipo toEntity(EquipoDTO equipoDTO) {
        Equipo equipo = new Equipo();
        if (equipoDTO.getId() != null) {
            equipo.setId(equipoDTO.getId());
        }
    
        equipo.setNombre(equipoDTO.getNombre());
        // No asignamos los jugadores aquí, ya que es probable que se maneje de forma separada
        return equipo;
    }
    
}

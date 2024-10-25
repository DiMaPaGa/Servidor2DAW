package com.vedruna.rest1n.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vedruna.rest1n.dto.JugadorDTO;
import com.vedruna.rest1n.persistance.models.Jugador;

@Component
public class JugadorMapper {

    public JugadorDTO toDTO(Jugador jugador) {
        return new JugadorDTO(jugador);
    }
    
    public Jugador toEntity(JugadorDTO jugadorDTO) {
        Jugador nuevoJugador = new Jugador();
        nuevoJugador.setNombre(jugadorDTO.getNombre());
        nuevoJugador.setEdad(jugadorDTO.getEdad());
        return nuevoJugador;
    }

    public List<JugadorDTO> toDTOList(List<Jugador>jugadores) {
        List<JugadorDTO>jugadoresDTO = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            jugadoresDTO.add(toDTO(jugador));
        }
        return jugadoresDTO;


    }

    public List<Jugador> toEntityList(List<JugadorDTO>jugadoresDTO) {
        List<Jugador>jugadores = new ArrayList<>();
        for (JugadorDTO jugador : jugadoresDTO) {
            jugadores.add(toEntity(jugador));
        }
        return jugadores;


    }
}

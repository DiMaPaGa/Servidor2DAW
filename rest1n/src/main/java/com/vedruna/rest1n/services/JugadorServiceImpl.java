package com.vedruna.rest1n.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.rest1n.dto.JugadorDTO;
import com.vedruna.rest1n.exceptions.PlayerNoFoundException;
import com.vedruna.rest1n.exceptions.TeamNoFoundException;
import com.vedruna.rest1n.mappers.JugadorMapper;
import com.vedruna.rest1n.persistance.models.Jugador;
import com.vedruna.rest1n.persistance.models.Equipo;
import com.vedruna.rest1n.persistance.repository.EquipoRepository;
import com.vedruna.rest1n.persistance.repository.JugadorRepository;

@Service
public class JugadorServiceImpl implements JugadorServiceI {

    @Autowired
    private JugadorRepository jugadorRepo;

    @Autowired
    private EquipoRepository equipoRepo;

    @Autowired
    private JugadorMapper jugadorMapper;

    // 3. Obtener todos los jugadores
    @Override
    public List <JugadorDTO> getAllPlayers() {
        List <Jugador> jugadores = jugadorRepo.findAll();
       return jugadorMapper.toDTOList(jugadores);
    }

    // 4. Crear un nuevo jugador
    @Override
    public JugadorDTO createPlayer(JugadorDTO jugadorDTO) {

        // Verificar si existe un jugador con el mismo nombre
        if (jugadorRepo.existsByNombre(jugadorDTO.getNombre())) {
            throw new IllegalArgumentException("Ya existe un jugador con el nombre: " + jugadorDTO.getNombre());
        }
        // Convertir el DTO de creación a una entidad Jugador
        Jugador nuevoJugador = jugadorMapper.toEntity(jugadorDTO);

        // Comprobar si se ha proporcionado un nombre de equipo
        if (jugadorDTO.getNombreEquipo() != null && !jugadorDTO.getNombreEquipo().isEmpty()) {
            Equipo equipo = equipoRepo.findByNombre(jugadorDTO.getNombreEquipo());
            if (equipo != null) {
                nuevoJugador.setEquipo(equipo); // Asignar el equipo al jugador
            }
        }
        
        // Guardar el nuevo jugador y convertirlo a DTO
        return jugadorMapper.toDTO(jugadorRepo.save(nuevoJugador));
    }

    // 6. Asignar un jugador a un equipo usando el nombre del equipo
    @Override
    public JugadorDTO assignTeamByName(Integer id, String nombreEquipo) throws PlayerNoFoundException, TeamNoFoundException {
        // Buscar el jugador por su ID
        Jugador jugador = jugadorRepo.findById(id).orElse(null);
        if (jugador == null) {
            throw new PlayerNoFoundException("Jugador no encontrado con ID: " + id);
        } // Jugador no encontrado
        

        // Buscar el equipo por su nombre
        Equipo equipo = equipoRepo.findByNombre(nombreEquipo);
        if (equipo == null) {
            throw new TeamNoFoundException("Equipo no encontrado: " + nombreEquipo);
        }

        // Asignar el jugador al equipo
        jugador.setEquipo(equipo); // Suponiendo que Jugador tiene una relación con Equipo
        jugadorRepo.save(jugador); // Guardar los cambios en la base de datos

        return jugadorMapper.toDTO(jugador); // Devolver el jugador actualizado
    }

    // 8. Borrar un jugador
    @Override
    public boolean deletePlayer(Integer id) {
        if (!jugadorRepo.existsById(id)) {
            return false; // Jugador no encontrado
        }
        jugadorRepo.deleteById(id);
        return true; // Jugador borrado
    }
}


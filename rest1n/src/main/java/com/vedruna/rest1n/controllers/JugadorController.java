
package com.vedruna.rest1n.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.rest1n.dto.JugadorDTO;
import com.vedruna.rest1n.exceptions.PlayerNoFoundException;
import com.vedruna.rest1n.exceptions.TeamNoFoundException;
import com.vedruna.rest1n.services.JugadorServiceI;



@RestController
@RequestMapping("/api/players")
public class JugadorController {

    @Autowired
    private JugadorServiceI jugadorService;

    // 3. Obtener todos los jugadores (mostrando solo el nombre del equipo)
    @GetMapping
    public ResponseEntity<List<JugadorDTO>> getAllPlayers() {
        List<JugadorDTO> jugadores = jugadorService.getAllPlayers();
        return ResponseEntity.ok(jugadores);
    }

    // 4. Crear un nuevo jugador
    @PostMapping
    public ResponseEntity<JugadorDTO> createPlayer(@RequestBody JugadorDTO jugadorDTO) throws TeamNoFoundException {
        JugadorDTO nuevoJugador = jugadorService.createPlayer(jugadorDTO);
        return ResponseEntity.ok(nuevoJugador);
    }

    // 6. Inscribir un jugador en un equipo usando el nombre del equipo
    @PutMapping("/{id}/insert")
    public ResponseEntity<JugadorDTO> assignTeamByName(@PathVariable Integer id, @RequestBody JugadorDTO jugadorDTO) throws PlayerNoFoundException, TeamNoFoundException {
        JugadorDTO jugador = jugadorService.assignTeamByName(id, jugadorDTO.getNombreEquipo());
        return ResponseEntity.ok(jugador);
    }

    // 8. Borrar un jugador (el equipo no debe borrarse)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Integer id) {
        boolean deleted = jugadorService.deletePlayer(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
    
}
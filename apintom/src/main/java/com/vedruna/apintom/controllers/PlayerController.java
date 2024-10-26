package com.vedruna.apintom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vedruna.apintom.dto.PlayerDTO;
import com.vedruna.apintom.persistance.models.Player;
import com.vedruna.apintom.services.PlayerServiceI;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerServiceI playerService;

    // Obtener todos los jugadores
    @GetMapping
    public ResponseEntity<List<PlayerDTO>> getAllPlayers() {
        List<PlayerDTO> players = playerService.getAllPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    // Obtener un jugador por ID
    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable int id) {
        PlayerDTO player = playerService.getPlayerById(id);
        return player != null ? new ResponseEntity<>(player, HttpStatus.OK) :
                                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Crear un nuevo jugador
    @PostMapping
    public ResponseEntity<Void> createPlayer(@RequestBody Player player) {
        playerService.savePlayer(player);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Borrar un jugador por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable int id) {
        playerService.deletePlayer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Asignar un trofeo a un jugador
    @PostMapping("/{playerId}/trophies/{trophyId}")
    public ResponseEntity<Void> assignTrophyToPlayer(@PathVariable int playerId, @PathVariable int trophyId) {
        playerService.assignTrophyToPlayer(playerId, trophyId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


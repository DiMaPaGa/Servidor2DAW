package com.vedruna.apintom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vedruna.apintom.dto.TrophyDTO;
import com.vedruna.apintom.persistance.models.Trophy;
import com.vedruna.apintom.services.TrophyServiceI;

@RestController
@RequestMapping("/trophies")
public class TrophyController {

    @Autowired
    private TrophyServiceI trophyService;

    // Obtener todos los trofeos
    @GetMapping
    public ResponseEntity<List<TrophyDTO>> getAllTrophies() {
        List<TrophyDTO> trophies = trophyService.getAllTrophies();
        return new ResponseEntity<>(trophies, HttpStatus.OK);
    }

    // Crear un nuevo trofeo
    @PostMapping
    public ResponseEntity<Void> createTrophy(@RequestBody Trophy trophy) {
        trophyService.saveTrophy(trophy);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
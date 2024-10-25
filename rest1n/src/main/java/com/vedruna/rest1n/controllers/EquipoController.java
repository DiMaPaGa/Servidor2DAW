package com.vedruna.rest1n.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.vedruna.rest1n.dto.EquipoDTO;
import com.vedruna.rest1n.mappers.EquipoMapper;
import com.vedruna.rest1n.persistance.models.Equipo;
import com.vedruna.rest1n.persistance.repository.EquipoRepository;
import com.vedruna.rest1n.services.EquipoServiceI;

@RestController
@RequestMapping("/api/v1/equipos")
public class EquipoController {

    @Autowired
    private EquipoServiceI equipoService;

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private EquipoMapper equipoMapper;

    // 1. Consultar todos los equipos (deben verse sus jugadores)
    @GetMapping
    public ResponseEntity<List<EquipoDTO>> getAllTeams() {
        List<Equipo> equipos = equipoService.getAllTeams();
        List<EquipoDTO> equiposDTO =new ArrayList<>();

        for (Equipo equipo : equipos) {
            equiposDTO.add(equipoMapper.toDTO(equipo));
        }
            
        return ResponseEntity.ok(equiposDTO);
    }

    // 2. Consultar un solo equipo por id (deben verse sus jugadores)
    @GetMapping("/{id}")
    public ResponseEntity<EquipoDTO> findTeamById(@PathVariable Integer id) {
        Equipo equipo = equipoService.findTeamById(id);
        if (equipo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(equipoMapper.toDTO(equipo));
    }

    //2b. Consultar un solo equipo por nombre (deben verse sus jugadores)
    @GetMapping("/search/{nombre}")
    public ResponseEntity<EquipoDTO> findTeamByName(@PathVariable String nombre) {
        Equipo equipo = equipoService.findTeamByName(nombre);
            if (equipo == null) {
            return ResponseEntity.notFound().build();
            }
        return ResponseEntity.ok(equipoMapper.toDTO(equipo));
    }

    // 5. Crear nuevo equipo
    @PostMapping
    public ResponseEntity<?> createTeam(@RequestBody EquipoDTO equipoDTO) {
        // Verificar si el nombre ya existe
        Equipo existingEquipo = equipoRepository.findByNombre(equipoDTO.getNombre());
        if (existingEquipo != null) {
            // Devuelve un error 400 si el nombre ya existe
            return ResponseEntity.badRequest().body("Ya existe un equipo con ese nombre.");
        }

        Equipo equipo = equipoService.createTeam(equipoMapper.toEntity(equipoDTO));
        return ResponseEntity.ok(equipoMapper.toDTO(equipo));
    }

    // 7. Borrar equipo (no deben borrarse sus jugadores)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Integer id) {
        boolean deleted = equipoService.deleteTeam(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }


    
}

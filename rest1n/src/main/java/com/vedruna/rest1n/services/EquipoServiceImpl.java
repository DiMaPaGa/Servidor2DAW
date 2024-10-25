package com.vedruna.rest1n.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.rest1n.mappers.EquipoMapper;
import com.vedruna.rest1n.persistance.models.Equipo;
import com.vedruna.rest1n.persistance.repository.EquipoRepository;

@Service
public class EquipoServiceImpl implements EquipoServiceI {

    @Autowired
    private EquipoRepository equipoRepo;

    @Autowired
    private EquipoMapper equipoMapper;

    // 1. Obtener todos los equipos
    @Override
    public List<Equipo> getAllTeams() {
        return equipoRepo.findAll();
    }

    // 2. Buscar un equipo por ID
    @Override
    public Equipo findTeamById(Integer id) {
        return equipoRepo.findById(id).orElse(null);  // Devolver null si no se encuentra
    }

    // 2b. Buscar un equipo por nombre
    @Override
    public Equipo findTeamByName(String nombre) {
        return equipoRepo.findByNombre(nombre);  // Devolver null si no se encuentra
    }

    // 5. Crear un nuevo equipo
    @Override
    public Equipo createTeam(Equipo equipo) {
        if (equipo.getJugadores() == null) {
            equipo.setJugadores(new ArrayList<>()); // Inicializa la lista si es nula
        }
        return equipoRepo.save(equipo);  // Guardar y devolver la entidad creada
    }

    // 7. Eliminar un equipo por ID
    @Override
    public boolean deleteTeam(Integer id) {
        if (!equipoRepo.existsById(id)) {
            return false;  // Retornar falso si no se encuentra el equipo
        }
        equipoRepo.deleteById(id);  // Eliminar equipo
        return true;  // Retornar verdadero si se elimina correctamente
    }
}

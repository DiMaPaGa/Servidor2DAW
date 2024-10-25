package com.vedruna.rest1n.services;

import java.util.List;

import com.vedruna.rest1n.persistance.models.Equipo;

public interface EquipoServiceI {

    // Obtener todos los equipos
    List<Equipo> getAllTeams();

    // Buscar equipo por ID
    Equipo findTeamById(Integer id);

    // Buscar equipo por nombre
    Equipo findTeamByName(String nombre);

    // Crear un equipo
    Equipo createTeam(Equipo equipo);

    // Eliminar un equipo por ID
    boolean deleteTeam(Integer id);
}

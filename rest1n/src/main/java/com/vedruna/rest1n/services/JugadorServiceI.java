package com.vedruna.rest1n.services;

import java.util.List;

import com.vedruna.rest1n.dto.JugadorDTO;
import com.vedruna.rest1n.exceptions.PlayerNoFoundException;
import com.vedruna.rest1n.exceptions.TeamNoFoundException;


public interface JugadorServiceI {
    List <JugadorDTO> getAllPlayers();
    JugadorDTO createPlayer(JugadorDTO jugadorDTO) throws TeamNoFoundException;
    JugadorDTO assignTeamByName(Integer id, String nombreEquipo) throws PlayerNoFoundException, TeamNoFoundException;
    boolean deletePlayer(Integer id);
}

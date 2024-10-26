package com.vedruna.apintom.services;

import java.util.List;
import com.vedruna.apintom.dto.PlayerDTO;
import com.vedruna.apintom.persistance.models.Player;

public interface PlayerServiceI {
    List<PlayerDTO> getAllPlayers();
    PlayerDTO getPlayerById(int id);
    void savePlayer(Player player);
    void deletePlayer(int id);
    void assignTrophyToPlayer(int playerId, int trophyId);
}
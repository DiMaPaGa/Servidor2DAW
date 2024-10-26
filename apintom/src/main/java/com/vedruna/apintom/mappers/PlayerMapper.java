package com.vedruna.apintom.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vedruna.apintom.dto.PlayerDTO;
import com.vedruna.apintom.persistance.models.Player;
import com.vedruna.apintom.persistance.models.Trophy;
import com.vedruna.apintom.persistance.repositories.TrophyRepository;

@Component
public class PlayerMapper {

    

    public PlayerDTO toDTO(Player player) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setIdplayer(player.getIdplayer());
        playerDTO.setUsername(player.getNombre());
        playerDTO.setWinnedTrophies(new ArrayList<>());

        for (Trophy trophy : player.getWinnedTrophies()) {
            playerDTO.getWinnedTrophies().add(trophy.getTitle());
        }

        return playerDTO;
    }

    
    
}

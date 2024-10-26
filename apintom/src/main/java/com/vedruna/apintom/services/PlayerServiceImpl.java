package com.vedruna.apintom.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.apintom.dto.PlayerDTO;
import com.vedruna.apintom.mappers.PlayerMapper;
import com.vedruna.apintom.persistance.models.Player;
import com.vedruna.apintom.persistance.models.Trophy;
import com.vedruna.apintom.persistance.repositories.PlayerRepository;
import com.vedruna.apintom.persistance.repositories.TrophyRepository;

@Service
public class PlayerServiceImpl implements PlayerServiceI {

    @Autowired
    private PlayerRepository playerRepo;

    @Autowired
    private TrophyRepository trophyRepo;

    @Autowired
    private PlayerMapper playerMapper;

    @Override
    public List<PlayerDTO> getAllPlayers() {
        List<Player> players = playerRepo.findAllByOrderByIdplayerAsc();
        List<PlayerDTO> playersDTO = new ArrayList<>();

        for (Player p : players) {
            playersDTO.add(playerMapper.toDTO(p));
        }
        return playersDTO;
    }

    @Override
    public PlayerDTO getPlayerById(int id) {
        Player player = playerRepo.findById(id).orElse(null);
        return player != null ? playerMapper.toDTO(player) : null;
    }

    @Override
    public void savePlayer(Player player) {
        player.setWinnedTrophies(new ArrayList<>()); // Inicializar lista vacía de trofeos
        playerRepo.save(player);
    }

    @Override
    public void deletePlayer(int id) {
        Player player = playerRepo.findById(id).orElse(null);
        if (player != null) {
            player.getWinnedTrophies().clear(); // Borramos los trofeos del jugador
            playerRepo.delete(player);
        }
    }

    @Override
    public void assignTrophyToPlayer(int playerId, int trophyId) {
        Player player = playerRepo.findById(playerId).orElse(null);
        Trophy trophy = trophyRepo.findById(trophyId).orElse(null);

        if (player != null && trophy != null) {
            player.getWinnedTrophies().add(trophy);
            playerRepo.save(player);
        }
    }
}


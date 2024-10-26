package com.vedruna.apintom.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.apintom.dto.TrophyDTO;
import com.vedruna.apintom.mappers.TrophyMapper;
import com.vedruna.apintom.persistance.models.Trophy;
import com.vedruna.apintom.persistance.repositories.TrophyRepository;

@Service
public class TrophyServiceImpl implements TrophyServiceI {

    @Autowired
    private TrophyRepository trophyRepo;

    @Autowired
    private TrophyMapper trophyMapper;

    @Override
    public List<TrophyDTO> getAllTrophies() {
        List<Trophy> trophies = trophyRepo.findAll();
        List<TrophyDTO> trophiesDTO = new ArrayList<>();

        for (Trophy trophy : trophies) {
            trophiesDTO.add(trophyMapper.toDTO(trophy));
        }
        return trophiesDTO;
    }

    @Override
    public void saveTrophy(Trophy trophy) {
        trophyRepo.save(trophy);
    }
}
package com.vedruna.apintom.mappers;

import org.springframework.stereotype.Component;

import com.vedruna.apintom.dto.TrophyDTO;
import com.vedruna.apintom.persistance.models.Trophy;

@Component
public class TrophyMapper {

    public TrophyDTO toDTO(Trophy trophy) {
        TrophyDTO trophyDTO = new TrophyDTO();
        trophyDTO.setIdtrophie(trophy.getIdtrophie());
        trophyDTO.setTitle(trophy.getTitle());
        trophyDTO.setDescription(trophy.getDescription());
        return trophyDTO;
    }

    public Trophy toEntity(TrophyDTO trophyDTO) {
        Trophy trophy = new Trophy();
        trophy.setIdtrophie(trophyDTO.getIdtrophie());
        trophy.setTitle(trophyDTO.getTitle());
        trophy.setDescription(trophyDTO.getDescription());
        return trophy;
    }
    
}

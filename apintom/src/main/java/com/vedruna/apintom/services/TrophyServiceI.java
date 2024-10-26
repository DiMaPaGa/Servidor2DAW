package com.vedruna.apintom.services;

import java.util.List;
import com.vedruna.apintom.dto.TrophyDTO;
import com.vedruna.apintom.persistance.models.Trophy;

public interface TrophyServiceI {
    List<TrophyDTO> getAllTrophies();
    void saveTrophy(Trophy trophy);
}

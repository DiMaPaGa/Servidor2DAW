package com.vedruna.apintom.dto;

import java.util.List;



import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class PlayerDTO {
    private int idplayer;
    private String username;
    private List<String> winnedTrophies;
}

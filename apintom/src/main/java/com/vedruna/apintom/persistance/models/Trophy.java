package com.vedruna.apintom.persistance.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "trophies")
public class Trophy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idtrophie", length = 45, nullable = false)
    private int idtrophie;

    @Column(name="title", length = 45, nullable = false, unique = true)
    private String title;

    @Column(name="description")
    private String description;

    @ManyToMany(mappedBy = "winnedTrophies")
    private List<Player> winnersPlayers;
    
}

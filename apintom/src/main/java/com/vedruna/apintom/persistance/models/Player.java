package com.vedruna.apintom.persistance.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "players")
public class Player implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idplayer", nullable = false)
    private int idplayer;  

    @Column(name="username", length = 45, nullable = false, unique = true)
    private String nombre;

    @ManyToMany (cascade = {CascadeType.ALL})
    @JoinTable(name = "players_has_trophies", joinColumns = {@JoinColumn(name = "players_idplayer")}, inverseJoinColumns = {@JoinColumn(name = "trophies_idtrophie")})
    private List<Trophy> winnedTrophies;
    
}

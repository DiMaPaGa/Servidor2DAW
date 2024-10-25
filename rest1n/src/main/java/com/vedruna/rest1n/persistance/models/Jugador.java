package com.vedruna.rest1n.persistance.models;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "jugadores")
public class Jugador implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idjugador", nullable = false)
    private int id;

    @Column(name="nombre", length = 45, nullable = false, unique = true)
    private String nombre;

    @Column(name="edad",nullable = false)
    private int edad;

    @ManyToOne(fetch= FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}) //CascadeType.Persist: hace que el Jugador persista incluso cuando aun no existe el equipo y MERGE: actualiza el equipo. No se añade Remove, porque sino al eliminar un equipo se borran todos los jugadores
    @JoinColumn(name="equipos_idequipo", referencedColumnName = "idequipo", nullable = true)
    private Equipo equipo;

    
}

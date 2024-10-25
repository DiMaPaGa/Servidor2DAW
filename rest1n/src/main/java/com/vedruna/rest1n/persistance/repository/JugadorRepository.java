package com.vedruna.rest1n.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedruna.rest1n.persistance.models.Equipo;
import com.vedruna.rest1n.persistance.models.Jugador;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {
    Jugador findByNombreAndEdad (String nombre, int edad);
    Jugador findByNombreAndEquipo (String nombre, Equipo equipo);
    boolean existsByNombre(String nombre);
}

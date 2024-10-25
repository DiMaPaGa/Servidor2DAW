package com.vedruna.rest1n.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedruna.rest1n.persistance.models.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
    Equipo findByNombre(String nombre);
}

package com.vedruna.rest1to1.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedruna.rest1to1.persistance.models.Alumno;

@Repository
public interface AlumnoRepositoryI extends JpaRepository<Alumno, Integer> {
    // Puedes agregar métodos de búsqueda adicionales si es necesario
    Alumno findByNombre(String nombre);
    Alumno findByApellidos(String apellidos);
}


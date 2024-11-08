package com.vedruna.pruebatecnica.persistance.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedruna.pruebatecnica.persistance.models.Country;

@Repository
public interface CountryRepository extends JpaRepository <Country, String> {
    // Método para buscar un país por su id
    Optional<Country> findById(String id);
    
}

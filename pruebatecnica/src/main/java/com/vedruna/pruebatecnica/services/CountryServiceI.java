package com.vedruna.pruebatecnica.services;


import org.springframework.data.domain.Page;

import com.vedruna.pruebatecnica.dto.CountryDTO;

public interface CountryServiceI {

    // Almacenar datos de países (endpoint 1) 
    void storeCountries();

    // Obtener todos los países almacenados (endpoint 2) -Devuelve lista de DTOs pasginados
    Page<CountryDTO> getAllCountriesPage(org.springframework.data.domain.Pageable pageable);


    
}

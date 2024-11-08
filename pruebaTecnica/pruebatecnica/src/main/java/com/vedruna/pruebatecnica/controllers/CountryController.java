package com.vedruna.pruebatecnica.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.pruebatecnica.dto.CountryDTO;
import com.vedruna.pruebatecnica.services.CountryServiceI;

@RestController
@RequestMapping("/api/v1/data/country")

public class CountryController {
    
    @Autowired
    private CountryServiceI countryService;



    /**
     * Endpoint para almacenar y actualizar los datos poblacionales de los países
     * obtenidos de la API externa en la base de datos local.
     * @return ResponseEntity con el código de estado HTTP correspondiente:
     *         - 201 (Created) si los datos se almacenan con éxito.
     *         - 500 (Internal Server Error) si ocurre un problema en el proceso.
     */
    @PostMapping
    public ResponseEntity<Void> storeCountries() {
        try {
            countryService.storeCountries(); 
            return new ResponseEntity<>(HttpStatus.CREATED);  
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);  
        }
    }

    /**
     * Endpoint para obtener los datos poblacionales de los países almacenados
     * en la base de datos con soporte para paginación.
     * @param pageable parámetro de paginación (página y tamaño).
     * @return ResponseEntity con la lista de países paginada en formato JSON.
     */
    @GetMapping
    public ResponseEntity<Page<CountryDTO>> getAllCountries(Pageable pageable) {
        Page<CountryDTO> countriesPage = countryService.getAllCountriesPage(pageable); 
        return new ResponseEntity<>(countriesPage, HttpStatus.OK);
    }
    
}

package com.vedruna.pruebatecnica.mappers;

import com.vedruna.pruebatecnica.dto.CountryDTO;
import com.vedruna.pruebatecnica.persistance.models.Country;

public class CountryMapper {
   
   /**
     * Convierte una entidad Country en un DTO CountryDTO.
     * @param country entidad de Country.
     * @return CountryDTO con datos del país.
     */
   public static CountryDTO toDto(Country country) {
    return new CountryDTO(
        country.getId(),
        country.getCountry(),
        country.getPopulation()
    );
}

/**
     * Convierte un DTO CountryDTO en una entidad Country.
     * @param countryDTO DTO de Country.
     * @return Country entidad representando los datos para almacenar.
     */
public static Country toEntity(CountryDTO countryDTO) {
    Country country = new Country();
    country.setId(countryDTO.getId());
    country.setCountry(countryDTO.getCountry());
    country.setPopulation(countryDTO.getPopulation());
    return country;
}
}

package com.vedruna.pruebatecnica.services;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vedruna.pruebatecnica.dto.CountryDTO;
import com.vedruna.pruebatecnica.mappers.CountryMapper;
import com.vedruna.pruebatecnica.persistance.models.Country;
import com.vedruna.pruebatecnica.persistance.repositories.CountryRepository;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.server.ResponseStatusException;


@Service
public class CountryServiceImpl implements CountryServiceI {

    private static final Logger logger = LoggerFactory.getLogger(CountryServiceImpl.class);

   @Autowired
    private CountryRepository countryRepository;
    private final WebClient webClient;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
        this.webClient = WebClient.builder().baseUrl("https://restcountries.com/v3.1/").build();
    }

    // Método auxiliar para mapear Country a CountryDTO
    private CountryDTO mapToDTO(Country country) {
        return new CountryDTO(country.getId(), country.getCountry(), country.getPopulation());
    }



    /**
     * Método que consulta la API externa para obtener datos de países
     * y los almacena en la base de datos, verificando si los datos ya existen
     * o necesitan actualización.
     */
    @Override
    public void storeCountries() {
        try {
            // Llamada a la API externa para obtener la información de los países
            List<Map<String, Object>> countries = webClient.get()
                                                        .uri("all")
                                                        .retrieve()
                                                        .bodyToFlux(new ParameterizedTypeReference<Map<String, Object>>() {})
                                                        .collectList()
                                                        .block();
            // Proceso de almacenamiento condicional
            if (countries != null) {
                for (Map<String, Object> countryData : countries) {
                    // Extraemos los datos necesarios de la respuesta de la API
                    String id = (String) countryData.get("ccn3");  // ccn3 como id
                    // Acceder al mapa "name" y luego obtener el valor de "common"
                    Map<String, Object> nameData = (Map<String, Object>) countryData.get("name");
                    String country = nameData != null ? (String) nameData.get("common") : null;

                    Long population = countryData.get("population") != null ? 
                                    ((Number) countryData.get("population")).longValue() : 0L;

                    // Solo almacenamos si tenemos un id y nombre válidos
                    if (id != null && country != null) {
                        Optional<Country> existingCountry = countryRepository.findById(id);

                        if (existingCountry.isPresent()) {           
                            Country countryEntity = existingCountry.get();

                            if (countryEntity.getPopulation() != population) {
                                countryEntity.setPopulation(population);
                                countryRepository.save(countryEntity);
                            }        
                        } else {
                        // Si no existe, lo creamos
                        Country newCountry = new Country();
                        newCountry.setId(id);
                        newCountry.setCountry(country);
                        newCountry.setPopulation(population);
                        countryRepository.save(newCountry);
                        }
                    }
                }
            }
        } catch (WebClientException e) {
            logger.error("Error al obtener datos de la API externa: ", e);
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Error al consumir la API de países");
        } catch (DataAccessException e) {
            // Error en la base de datos
            logger.error("Error al almacenar datos en la base de datos: ", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al guardar datos de países");
        } catch (Exception e) {
            // Cualquier otro error inesperado
            logger.error("Error inesperado en el almacenamiento de datos de países: ", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error inesperado al guardar datos");
        }
        
    }

    /**
     * Método para obtener todos los países almacenados en la base de datos en formato de página.
     * @param pageable objeto de paginación para limitar los resultados.
     * @return Página de CountryDTO representando los datos de los países.
     */
    @Override
    public Page<CountryDTO> getAllCountriesPage(Pageable pageable) {
        Page<Country> countriesPage = countryRepository.findAll(pageable);
        return countriesPage.map(CountryMapper::toDto);
    }
}

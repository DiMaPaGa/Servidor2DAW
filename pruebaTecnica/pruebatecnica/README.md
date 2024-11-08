# Proyecto de API de Datos Poblacionales

## Descripción
Este proyecto es una API RESTful que permite almacenar y recuperar datos poblacionales de países, utilizando la API externa de [REST Countries](https://restcountries.com/v3.1/all).

## Tecnologías Utilizadas
- **Java** con **Spring Boot** para el desarrollo de la API.
- **Base de datos relacional** MySQL. El .sql con la creación de la BBDD y la tabla se encuentra dentro de la carpeta resources denominado como "schema.sql".
- **Spring Data JPA** para acceso y manipulación de datos.
- **WebClient** para llamadas HTTP asíncronas.

## Endpoints
- **POST /api/v1/data/country**: Consulta la API externa y almacena los datos poblacionales en la base de datos.
- **GET /api/v1/data/country**: Devuelve los datos de la base de datos en formato JSON con soporte de paginación.

## Ejecución del Proyecto
1. Compilar el proyecto.
2. Ejecutar el proyecto. Puede emplearse el siguiente comando:
   ```bash
   mvn spring-boot:run
   ```





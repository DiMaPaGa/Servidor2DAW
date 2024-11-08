CREATE DATABASE poblacionDB;

CREATE TABLE countries (
    ccn3 VARCHAR(3) PRIMARY KEY,  
    country VARCHAR(100) NOT NULL,    
    population BIGINT NOT NULL     
);

ALTER TABLE countries
MODIFY COLUMN ccn3 VARCHAR(255) NOT NULL DEFAULT 'valor_predeterminado';
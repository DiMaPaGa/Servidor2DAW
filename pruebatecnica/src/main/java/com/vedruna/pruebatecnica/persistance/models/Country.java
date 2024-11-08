package com.vedruna.pruebatecnica.persistance.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "countries")

public class Country implements Serializable {

    @Id
    @Column (name="ccn3")
    private String id;

    @Column (name="country", length = 100, nullable = false, unique = true)
    private String country;

    @Column (name="population", nullable = false)
    private long population;

    
}

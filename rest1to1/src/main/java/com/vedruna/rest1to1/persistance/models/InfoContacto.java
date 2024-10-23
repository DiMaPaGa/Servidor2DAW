package com.vedruna.rest1to1.persistance.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="infocontacto")
public class InfoContacto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idinfocontacto")
    private int id;

    @Column(name="direccion", length = 45, nullable = false)
    private String direccion;

    @Column(name="telefono", nullable = false)
    private int telefono;

    @OneToOne
    @JoinColumn(name = "alumnos_idalumno", referencedColumnName = "idalumno")  // Referencia al id de Alumno
    private Alumno alumno;
}


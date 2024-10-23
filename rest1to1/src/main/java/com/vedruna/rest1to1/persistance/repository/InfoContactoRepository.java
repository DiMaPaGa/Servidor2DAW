package com.vedruna.rest1to1.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vedruna.rest1to1.persistance.models.InfoContacto;

@Repository
public interface InfoContactoRepository extends JpaRepository<InfoContacto, Integer> {
    
    // Método para encontrar información de contacto por el ID del alumno
    InfoContacto findByAlumnoId(int alumnoId);
    
    // Método para eliminar la información de contacto por ID de alumno
    void deleteByAlumnoId(int alumnoId);
}

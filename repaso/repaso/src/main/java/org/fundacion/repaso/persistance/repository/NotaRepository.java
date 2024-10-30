package org.fundacion.repaso.persistance.repository;

import java.util.List;

import org.fundacion.repaso.persistance.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {
    List<Nota> findByAlumnoCalificado_AlumnoId(Long alumnoId);
    List<Nota> findByAsignatura_AsignaturaId(Long asignaturaId);
    List<Nota> findByAlumnoCalificado_AlumnoIdAndAsignatura_AsignaturaId(Long alumnoId, Long asignaturaId);
}



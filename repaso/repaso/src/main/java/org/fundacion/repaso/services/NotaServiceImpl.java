package org.fundacion.repaso.services;

import java.util.List;
import java.util.stream.Collectors;

import org.fundacion.repaso.dto.NotaDTO;
import org.fundacion.repaso.persistance.model.Nota;
import org.fundacion.repaso.persistance.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotaServiceImpl implements NotaServiceI {

    @Autowired
    private NotaRepository notaRepo;

    @Override
    public List<NotaDTO> getNotasByAlumnoId(Long alumnoId) {
        List<Nota> notas = notaRepo.findByAlumnoCalificado_AlumnoId(alumnoId);
        return notas.stream().map(NotaDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<NotaDTO> getNotasByAsignaturaId(Long asignaturaId) {
        List<Nota> notas = notaRepo.findByAsignatura_AsignaturaId(asignaturaId);
        return notas.stream().map(NotaDTO::new).collect(Collectors.toList());
    }

   

    @Override
    public void insertNota(Nota nuevaNota) {
        notaRepo.save(nuevaNota); // Guarda la nueva nota en el repositorio
    }

    @Override
public List<NotaDTO> getNotasByAlumnoYAsignatura(Long alumnoId, Long asignaturaId) {
    // Utilizar el repositorio de Nota para encontrar las notas por alumno y asignatura
    List<Nota> notas = notaRepo.findByAlumnoCalificado_AlumnoIdAndAsignatura_AsignaturaId(alumnoId, asignaturaId);
    return notas.stream().map(NotaDTO::new).collect(Collectors.toList());
}
}


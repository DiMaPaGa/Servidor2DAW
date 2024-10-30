package org.fundacion.repaso.services;

import java.util.List;

import org.fundacion.repaso.dto.NotaDTO;
import org.fundacion.repaso.persistance.model.Nota;

public interface NotaServiceI {
    public List<NotaDTO> getNotasByAlumnoId(Long alumnoId);
    public List<NotaDTO> getNotasByAsignaturaId(Long asignaturaId);
    public List<NotaDTO> getNotasByAlumnoYAsignatura(Long alumnoId, Long asignaturaId);
    public void insertNota(Nota nuevaNota);
}

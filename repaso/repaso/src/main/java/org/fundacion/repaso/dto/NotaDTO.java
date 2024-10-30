package org.fundacion.repaso.dto;

import org.fundacion.repaso.persistance.model.Nota;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NotaDTO {
    private Long alumnoId; 
    private Long asignaturaId; 
    private String nombreTrabajo;
    private float calificacion;

    public NotaDTO(Nota n) {
        this.alumnoId = n.getAlumnoCalificado().getAlumnoId();
        this.asignaturaId = n.getAsignatura().getAsignaturaId();
        this.calificacion = n.getCalificacion();
        this.nombreTrabajo = n.getNombreTrabajo();
    }
}

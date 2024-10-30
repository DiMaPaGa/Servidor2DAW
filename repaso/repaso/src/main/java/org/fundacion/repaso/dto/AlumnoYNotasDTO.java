package org.fundacion.repaso.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AlumnoYNotasDTO {
    private Long id;
    private String name;
    private List<NotaDTO> notas;
    
}

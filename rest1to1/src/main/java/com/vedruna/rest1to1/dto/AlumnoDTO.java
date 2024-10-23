package com.vedruna.rest1to1.dto;

import com.vedruna.rest1to1.persistance.models.Alumno;
import com.vedruna.rest1to1.persistance.models.InfoContacto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoDTO {
    private Integer id; // Cambiar a Integer según el tipo en la base de datos
    private String nombre;
    private String apellidos;
    private InfoContactoDTO infoContacto;

    public AlumnoDTO(Alumno alumno) {
        this.id = alumno.getId();
        this.nombre = alumno.getNombre();
        this.apellidos = alumno.getApellidos();
    
  // Mapeo de InfoContacto a InfoContactoDTO, si existe
        InfoContacto contacto = alumno.getInfoContacto();
        if (contacto != null) {
            this.infoContacto = new InfoContactoDTO(contacto);
        }
    }

    // Método getInfoContacto ya implementado
    public InfoContactoDTO getInfoContacto() {
        return this.infoContacto;
    }
}



package com.vedruna.rest1to1.services;

import java.util.List;

import com.vedruna.rest1to1.dto.AlumnoDTO;
import com.vedruna.rest1to1.dto.AlumnoSinContactoDTO;
import com.vedruna.rest1to1.dto.InfoContactoDTO;

public interface AlumnoServiceI {
    List<AlumnoSinContactoDTO> showAllAlumnos();
    AlumnoSinContactoDTO showAlumnoById(int id);
    InfoContactoDTO showInfoContactoByAlumnoId(int id);
    void saveAlumno(AlumnoDTO alumnoDTO);
    void deleteAlumno(int id);
}


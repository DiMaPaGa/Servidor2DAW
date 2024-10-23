package com.vedruna.rest1to1.controllers;

import com.vedruna.rest1to1.dto.AlumnoSinContactoDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vedruna.rest1to1.dto.AlumnoDTO;
import com.vedruna.rest1to1.dto.InfoContactoDTO;
import com.vedruna.rest1to1.services.AlumnoServiceI;

@RestController
@RequestMapping("/api/v1/alumnos")
@CrossOrigin
public class AlumnoController {

    @Autowired
    private AlumnoServiceI alumnoService;

    @GetMapping
    public List<AlumnoSinContactoDTO> getAllAlumnos() {
        return alumnoService.showAllAlumnos();
    }

    @GetMapping("/{id}")
    public AlumnoSinContactoDTO getAlumnoById(@PathVariable int id) {
        return alumnoService.showAlumnoById(id);  // Cambiar el servicio para devolver AlumnoSinContactoDTO
    }

    @GetMapping("/{id}/contacto")
    public InfoContactoDTO getInfoContactoByAlumnoId(@PathVariable int id) {
        return alumnoService.showInfoContactoByAlumnoId(id);
    }

    @PostMapping
    public String createAlumno(@RequestBody AlumnoDTO alumnoDTO) {
        alumnoService.saveAlumno(alumnoDTO);
        return "Alumno saved";
    }

    @DeleteMapping("/{id}")
    public String deleteAlumno(@PathVariable int id) {
        alumnoService.deleteAlumno(id);
        return "Alumno deleted";
    }
}

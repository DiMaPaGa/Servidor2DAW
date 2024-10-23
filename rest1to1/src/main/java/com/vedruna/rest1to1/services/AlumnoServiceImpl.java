package com.vedruna.rest1to1.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.rest1to1.dto.AlumnoDTO;
import com.vedruna.rest1to1.dto.AlumnoSinContactoDTO;
import com.vedruna.rest1to1.dto.InfoContactoDTO;
import com.vedruna.rest1to1.persistance.models.Alumno;
import com.vedruna.rest1to1.persistance.models.InfoContacto;
import com.vedruna.rest1to1.persistance.repository.AlumnoRepositoryI;
import com.vedruna.rest1to1.persistance.repository.InfoContactoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoServiceI {

    @Autowired
    private AlumnoRepositoryI alumnoRepo;

    @Autowired
    private InfoContactoRepository infoContactoRepo;

    @Override
    public List<AlumnoSinContactoDTO> showAllAlumnos() {
        List<Alumno> alumnos = alumnoRepo.findAll();
        List<AlumnoSinContactoDTO> alumnosDTO = new ArrayList<>();

        for (Alumno a : alumnos) {
            AlumnoSinContactoDTO dto = new AlumnoSinContactoDTO(a.getId(), a.getNombre(), a.getApellidos());
            alumnosDTO.add(dto);
        }

        return alumnosDTO;
    }

    @Override
    public AlumnoSinContactoDTO showAlumnoById(int id) {
        Alumno alumno = alumnoRepo.findById(id).orElse(null);
        return alumno != null ? new AlumnoSinContactoDTO(alumno.getId(), alumno.getNombre(), alumno.getApellidos()) : null;
    }

    @Override
    public InfoContactoDTO showInfoContactoByAlumnoId(int id) {
        InfoContacto infoContacto = infoContactoRepo.findByAlumnoId(id); // Método que debes definir en el repositorio
        return infoContacto != null ? new InfoContactoDTO(infoContacto) : null;
    }

    @Override
    public void saveAlumno(AlumnoDTO alumnoDTO) {
        // Convertir AlumnoDTO a Alumno
        Alumno nuevoAlumno = new Alumno();
        nuevoAlumno.setNombre(alumnoDTO.getNombre());
        nuevoAlumno.setApellidos(alumnoDTO.getApellidos());
    
        // Verifica que el contacto no sea null
        if (alumnoDTO.getInfoContacto() != null) {
        InfoContacto infoContacto = new InfoContacto();
        infoContacto.setDireccion(alumnoDTO.getInfoContacto().getDireccion());
        infoContacto.setTelefono(alumnoDTO.getInfoContacto().getTelefono());

        nuevoAlumno.setInfoContacto(infoContacto);
        infoContacto.setAlumno(nuevoAlumno);
    }

    // Guarda primero el alumno y luego la información de contacto
    alumnoRepo.save(nuevoAlumno);
}


    @Override
    public void deleteAlumno(int id) {
        alumnoRepo.deleteById(id);
    }
}



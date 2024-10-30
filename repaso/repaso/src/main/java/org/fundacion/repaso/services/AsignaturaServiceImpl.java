package org.fundacion.repaso.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.fundacion.repaso.dto.AlumnoDTO;
import org.fundacion.repaso.dto.AsignaturaDTO;
import org.fundacion.repaso.dto.NotaDTO;
import org.fundacion.repaso.persistance.model.Alumno;
import org.fundacion.repaso.persistance.model.Asignatura;
import org.fundacion.repaso.persistance.model.Nota;
import org.fundacion.repaso.persistance.repository.AsignaturaRepository;
import org.fundacion.repaso.persistance.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaServiceImpl implements AsignaturaServiceI {

    @Autowired
    private AsignaturaRepository asignaturaRepo;

    @Autowired
    private NotaRepository notaRepo;

    @Override
    public List<AsignaturaDTO> getAsignaturas() {
        List<Asignatura> asignaturaList = asignaturaRepo.findAll();
        List<AsignaturaDTO> asignaturaDTOList = new ArrayList<AsignaturaDTO>();
        for (Asignatura asignatura : asignaturaList) {
            asignaturaDTOList.add(new AsignaturaDTO(asignatura));
        }
        return asignaturaDTOList;
    }

    @Override
    public AsignaturaDTO getNotasPorAlumnoYAsignatura(Long asignaturaId) {
        Asignatura asignatura = asignaturaRepo.findByAsignaturaId(asignaturaId);

        //Recorro cada alumno y recorro sus notas. Si la nota pertenece a la asignatura, la agrego a una nueva lista que sustituirá a la lista de notas total.
        for (Alumno alumno : asignatura.getAlumnosMatriculados()) {
            List<Nota> notas = new ArrayList<>();
            for (Nota cualquierNota : alumno.getNotas()) {
                if (cualquierNota.getAsignatura().getAsignaturaId().equals(asignaturaId)) {
                    notas.add(cualquierNota);
                }
            }
            alumno.setNotas(notas);
        }

        return new AsignaturaDTO(asignatura);

    }

}

package com.example.reservabackmathews.service;

import com.example.reservabackmathews.dtos.AlumnoCreateDTO;
import com.example.reservabackmathews.dtos.AlumnoDTO;
import com.example.reservabackmathews.dtos.AlumnoUpdateDTO;
import com.example.reservabackmathews.mappers.AlumnoMapper;
import com.example.reservabackmathews.model.Alumno;
import com.example.reservabackmathews.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;
    @Override
    public List<AlumnoDTO> listarAlumnos() {
        return AlumnoMapper.instancia.listaAlumnoAListaAlumnoDTO( alumnoRepository.findAll());
    }

    @Override
    public AlumnoDTO obtenerAlumnoPorID(long id) {
        Optional<Alumno> alumno= alumnoRepository.findById(id);
        AlumnoDTO alumnoDTO ;
        if(alumno.isPresent()){
            alumnoDTO = AlumnoMapper.instancia.alumnoAAlumnoDTO(alumno.get());
        }else {
            alumnoDTO=null;
        }
        return  alumnoDTO;
    }

    @Override
    public AlumnoDTO registrarAlumno(AlumnoCreateDTO alumnoCreateDTO) {
        Alumno alumno=AlumnoMapper.instancia.alumnoCreatedDTOAAlumno(alumnoCreateDTO);
        Alumno respuestaEntity = alumnoRepository.save(alumno);
        AlumnoDTO respuestaDTO= AlumnoMapper.instancia.alumnoAAlumnoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public AlumnoDTO actualizarAlumno(AlumnoUpdateDTO alumnoUpdateDTO) {
        Alumno alumno=AlumnoMapper.instancia.alumnoUpdateDTOAAlumno(alumnoUpdateDTO);
        Alumno respuestaEntity=alumnoRepository.save(alumno);
        AlumnoDTO respuestaDTO= AlumnoMapper.instancia.alumnoAAlumnoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public AlumnoDTO eliminarAlumno(long id) {
        Optional<Alumno> alumnoOptional= alumnoRepository.findById(id);
        AlumnoDTO alumnoDTO = new AlumnoDTO();
        String resultado ;
        if(alumnoOptional.isPresent()){
            alumnoDTO=AlumnoMapper.instancia.alumnoAAlumnoDTO(alumnoOptional.get());
            alumnoRepository.delete(alumnoOptional.get());
            return alumnoDTO;
        }else {
            resultado="No se pudo realizar la eliminación";
        }
        return alumnoDTO;
    }
}

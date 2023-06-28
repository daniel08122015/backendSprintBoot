package com.example.reservabackmathews.mappers;

import com.example.reservabackmathews.dtos.AlumnoCreateDTO;
import com.example.reservabackmathews.dtos.AlumnoDTO;
import com.example.reservabackmathews.dtos.AlumnoUpdateDTO;
import com.example.reservabackmathews.model.Alumno;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlumnoMapper {

    AlumnoMapper instancia = Mappers.getMapper(AlumnoMapper.class);

    AlumnoDTO alumnoAAlumnoDTO(Alumno alumno);
    Alumno alumnoDTOAAlumno(AlumnoDTO alumnoDTO);

    Alumno alumnoCreatedDTOAAlumno(AlumnoCreateDTO alumnoCreateDTO);

    Alumno alumnoUpdateDTOAAlumno(AlumnoUpdateDTO alumnoUpdateDTO);

    List<AlumnoDTO> listaAlumnoAListaAlumnoDTO (List<Alumno> listaAlumno);








}

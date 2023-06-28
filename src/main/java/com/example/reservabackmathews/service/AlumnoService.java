package com.example.reservabackmathews.service;

import com.example.reservabackmathews.dtos.AlumnoCreateDTO;
import com.example.reservabackmathews.dtos.AlumnoDTO;
import com.example.reservabackmathews.dtos.AlumnoUpdateDTO;

import java.util.List;

public interface AlumnoService {

    List<AlumnoDTO> listarAlumnos();

    AlumnoDTO obtenerAlumnoPorID(long id);

    AlumnoDTO registrarAlumno(AlumnoCreateDTO alumnoCreateDTO);

    AlumnoDTO actualizarAlumno(AlumnoUpdateDTO alumnoUpdateDTO);

    AlumnoDTO eliminarAlumno(long id);




}

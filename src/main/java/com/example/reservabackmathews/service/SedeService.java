package com.example.reservabackmathews.service;

import com.example.reservabackmathews.dtos.AlumnoDTO;
import com.example.reservabackmathews.dtos.SedeDTO;

import java.util.List;

public interface SedeService {

    List<SedeDTO> listarSedes();

    SedeDTO obtenerSedesPorID(long id);
}

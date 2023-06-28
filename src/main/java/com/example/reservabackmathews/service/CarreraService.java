package com.example.reservabackmathews.service;

import com.example.reservabackmathews.dtos.CarreraCreateDTO;
import com.example.reservabackmathews.dtos.CarreraDTO;
import com.example.reservabackmathews.dtos.CarreraUpdateDTO;

import java.util.List;

public interface CarreraService {

    List<CarreraDTO> listarCarreras();
    CarreraDTO obtenerCarreraPorID(long id);
    CarreraDTO registrarCarrera(CarreraCreateDTO carreraCreateDTO);
    CarreraDTO actualizarCarrera(CarreraUpdateDTO carreraUpdateDTO);
    CarreraDTO eliminarCarrera(long id);
}

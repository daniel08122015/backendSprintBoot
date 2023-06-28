package com.example.reservabackmathews.service;

import com.example.reservabackmathews.dtos.*;

import java.util.List;

public interface EmpleadoService {

    List<EmpleadoDTO> listarEmpleados();

    EmpleadoDTO obtenerEmpleadoPorID(long id);

    EmpleadoDTO registrarEmpleado(EmpleadoCreateDTO empleadoCreateDTO);

    EmpleadoDTO actualizarEmpleado(EmpleadoUpdateDTO empleadoUpdateDTO);

    EmpleadoDTO eliminarAEmpleado(long id);
}

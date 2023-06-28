package com.example.reservabackmathews.mappers;

import com.example.reservabackmathews.dtos.*;
import com.example.reservabackmathews.model.Alumno;
import com.example.reservabackmathews.model.Empleado;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmpleadoMapper {

    EmpleadoMapper instancia = Mappers.getMapper(EmpleadoMapper.class);

    EmpleadoDTO empleadoAEmpleadoDTO(Empleado empleado);
    Empleado empleadoDTOAEmpleado(EmpleadoDTO empleadoDTO);

    Empleado empleadoCreatedDTOAEmpleado(EmpleadoCreateDTO empleadoCreateDTO);

    Empleado empleadoUpdateDTOAEmpleado(EmpleadoUpdateDTO empleadoUpdateDTO);

    List<EmpleadoDTO> listaEmpleadoAListaEmpleadoDTO (List<Empleado> listaEmpleado);
}

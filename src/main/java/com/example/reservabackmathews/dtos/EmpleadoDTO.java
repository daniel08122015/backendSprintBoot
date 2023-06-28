package com.example.reservabackmathews.dtos;

import com.example.reservabackmathews.model.Carrera;
import com.example.reservabackmathews.model.Sede;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmpleadoDTO {

    private Long idEmpleado;
    private String nombre;
    private String apellido;
    private String email;
    private Integer telefono;
    private Date fechaIngreso;

}

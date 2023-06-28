package com.example.reservabackmathews.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmpleadoUpdateDTO {
    private Long idEmpleado;
    private String nombre;
    private String apellido;
    private String email;
    private Integer telefono;
    private Date fechaIngreso;
}

package com.example.reservabackmathews.dtos;

import com.example.reservabackmathews.model.Carrera;
import com.example.reservabackmathews.model.Sede;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class AlumnoUpdateDTO {
    private Long codAlumno;
    private String nombres;
    private String apePaterno;
    private String apeMaterno;
    private Integer celular;
    private String email;
    private Date fechaReserva;

    private Sede sede;

    private Carrera carrera;
}

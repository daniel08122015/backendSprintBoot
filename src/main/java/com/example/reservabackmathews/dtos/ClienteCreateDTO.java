package com.example.reservabackmathews.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ClienteCreateDTO {
    private Long codCliente;
    private String nombres;
    private String apePaterno;
    private String apeMaterno;
    private Integer dni;
    private Date fechaNacimiento;
    private String email;
}

package com.example.reservabackmathews.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UsuarioDTO {
    private Long idUsuario;
    private String nombre;
    private String password;
    private String email;
    private String rol;
}

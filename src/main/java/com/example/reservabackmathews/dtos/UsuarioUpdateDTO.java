package com.example.reservabackmathews.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioUpdateDTO {
    private Long idUsuario;
    private String nombre;
    private String password;
    private String email;
    private String rol;
}

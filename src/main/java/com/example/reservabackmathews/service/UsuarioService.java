package com.example.reservabackmathews.service;

import com.example.reservabackmathews.dtos.*;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDTO> listarUsuarios();

    UsuarioDTO obtenerUsuarioPorID(long id);

    UsuarioDTO registrarUsuario(UsuarioCreateDTO usuarioCreateDTO);

    UsuarioDTO actualizarUsuario(UsuarioUpdateDTO usuarioUpdateDTO);

    UsuarioDTO eliminarUsuario(long id);
}

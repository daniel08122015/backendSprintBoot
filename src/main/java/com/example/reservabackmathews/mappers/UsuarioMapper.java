package com.example.reservabackmathews.mappers;

import com.example.reservabackmathews.dtos.*;
import com.example.reservabackmathews.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper instancia = Mappers.getMapper(UsuarioMapper.class);

    UsuarioDTO usuarioAUsuarioDTO(Usuario usuario);
    Usuario usuarioDTOAUsuario(UsuarioDTO usuarioDTO);

    Usuario usuarioCreatedDTOAUsuario(UsuarioCreateDTO usuarioCreateDTO);

    Usuario usuarioUpdateDTOAUsuario(UsuarioUpdateDTO usuarioUpdateDTO);

    List<UsuarioDTO> listaUsuarioAListaUsuarioDTO (List<Usuario> listaUsuario);
}

package com.example.reservabackmathews.mappers;

import com.example.reservabackmathews.dtos.*;
import com.example.reservabackmathews.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClienteMapper {
    ClienteMapper instancia = Mappers.getMapper(ClienteMapper.class);

    ClienteDTO clienteAClienteDTO(Cliente cliente);
    Cliente clienteDTOACliente(ClienteDTO clienteDTO);

    Cliente clienteCreatedDTOACliente(ClienteCreateDTO clienteCreateDTO);

    Cliente clienteUpdateDTOACliente(ClienteUpdateDTO clienteUpdateDTO);

    List<ClienteDTO> listaClienteAListaClienteDTO (List<Cliente> listaCliente);
}

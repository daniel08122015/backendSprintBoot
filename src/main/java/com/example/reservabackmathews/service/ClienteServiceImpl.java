package com.example.reservabackmathews.service;
import com.example.reservabackmathews.dtos.ClienteCreateDTO;
import com.example.reservabackmathews.dtos.ClienteDTO;
import com.example.reservabackmathews.dtos.ClienteUpdateDTO;
import com.example.reservabackmathews.mappers.ClienteMapper;
import com.example.reservabackmathews.model.Cliente;
import com.example.reservabackmathews.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> listarClientes() {
        return ClienteMapper.instancia.listaClienteAListaClienteDTO( clienteRepository.findAll());
    }

    @Override
    public ClienteDTO obtenerClientePorID(long id) {
        Optional<Cliente> cliente= clienteRepository.findById(id);
        ClienteDTO clienteDTO ;
        if(cliente.isPresent()){
            clienteDTO = ClienteMapper.instancia.clienteAClienteDTO(cliente.get());
        }else {
            clienteDTO=null;
        }
        return  clienteDTO;
    }

    @Override
    public ClienteDTO registrarCliente(ClienteCreateDTO clienteCreateDTO) {
        Cliente cliente=ClienteMapper.instancia.clienteCreatedDTOACliente(clienteCreateDTO);
        Cliente respuestaEntity = clienteRepository.save(cliente);
        ClienteDTO respuestaDTO= ClienteMapper.instancia.clienteAClienteDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public ClienteDTO actualizarCliente(ClienteUpdateDTO clienteUpdateDTO) {
        Cliente cliente=ClienteMapper.instancia.clienteUpdateDTOACliente(clienteUpdateDTO);
        Cliente respuestaEntity = clienteRepository.save(cliente);
        ClienteDTO respuestaDTO= ClienteMapper.instancia.clienteAClienteDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public ClienteDTO eliminarCliente(long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        ClienteDTO clienteDTO = new ClienteDTO();
        String resultado ;
        if(clienteOptional.isPresent()){
            clienteDTO=ClienteMapper.instancia.clienteAClienteDTO(clienteOptional.get());
            clienteRepository.delete(clienteOptional.get());
            return clienteDTO;
        }else {
            resultado="No se pudo realizar la eliminación del cliente";
        }
        return clienteDTO;
    }
}

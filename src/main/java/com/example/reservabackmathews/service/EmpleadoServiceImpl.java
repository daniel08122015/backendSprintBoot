package com.example.reservabackmathews.service;

import com.example.reservabackmathews.dtos.EmpleadoCreateDTO;
import com.example.reservabackmathews.dtos.EmpleadoDTO;
import com.example.reservabackmathews.dtos.EmpleadoUpdateDTO;
import com.example.reservabackmathews.mappers.EmpleadoMapper;
import com.example.reservabackmathews.model.Empleado;
import com.example.reservabackmathews.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Override
    public List<EmpleadoDTO> listarEmpleados() {
        return EmpleadoMapper.instancia.listaEmpleadoAListaEmpleadoDTO( empleadoRepository.findAll());
    }

    @Override
    public EmpleadoDTO obtenerEmpleadoPorID(long id) {
        Optional<Empleado> empleado= empleadoRepository.findById(id);
        EmpleadoDTO empleadoDTO ;
        if(empleado.isPresent()){
            empleadoDTO = EmpleadoMapper.instancia.empleadoAEmpleadoDTO(empleado.get());
        }else {
            empleadoDTO=null;
        }
        return  empleadoDTO;
    }

    @Override
    public EmpleadoDTO registrarEmpleado(EmpleadoCreateDTO empleadoCreateDTO) {
        Empleado empleado=EmpleadoMapper.instancia.empleadoCreatedDTOAEmpleado(empleadoCreateDTO);
        Empleado respuestaEntity = empleadoRepository.save(empleado);
        EmpleadoDTO respuestaDTO= EmpleadoMapper.instancia.empleadoAEmpleadoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public EmpleadoDTO actualizarEmpleado(EmpleadoUpdateDTO empleadoUpdateDTO) {
        Empleado empleado=EmpleadoMapper.instancia.empleadoUpdateDTOAEmpleado(empleadoUpdateDTO);
        Empleado respuestaEntity = empleadoRepository.save(empleado);
        EmpleadoDTO respuestaDTO= EmpleadoMapper.instancia.empleadoAEmpleadoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public EmpleadoDTO eliminarAEmpleado(long id) {
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        String resultado ;
        if(empleadoOptional.isPresent()){
            empleadoDTO=EmpleadoMapper.instancia.empleadoAEmpleadoDTO(empleadoOptional.get());
            empleadoRepository.delete(empleadoOptional.get());
            return empleadoDTO;
        }else {
            resultado="No se pudo realizar la eliminación del empleado";
        }
        return empleadoDTO;
    }
}

package com.example.reservabackmathews.mappers;

import com.example.reservabackmathews.dtos.CarreraCreateDTO;
import com.example.reservabackmathews.dtos.CarreraDTO;
import com.example.reservabackmathews.dtos.CarreraUpdateDTO;
import com.example.reservabackmathews.model.Carrera;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarreraMapper {

    CarreraMapper instance = Mappers.getMapper(CarreraMapper.class);

    CarreraDTO carreraACarreraDTO(Carrera carrera);
    Carrera carreraDTOACarrera(CarreraDTO carreraDTO);

    Carrera carreraCreatedDTOACarrera(CarreraCreateDTO carreraCreateDTO);

    Carrera carreraUpdateDTOACarrera(CarreraUpdateDTO carreraUpdateDTO);

    List<CarreraDTO> listaCarreraAListaCarreraDTO (List<Carrera> listaCarrera);


}

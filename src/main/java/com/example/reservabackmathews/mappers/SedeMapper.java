package com.example.reservabackmathews.mappers;

import com.example.reservabackmathews.dtos.CarreraDTO;
import com.example.reservabackmathews.dtos.SedeDTO;
import com.example.reservabackmathews.model.Carrera;
import com.example.reservabackmathews.model.Sede;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SedeMapper {

    SedeMapper instance = Mappers.getMapper(SedeMapper.class);

    SedeDTO sedeASedeDTO(Sede sede);

    Sede sedeDTOASede(SedeDTO sedeDTO);

    List<SedeDTO> listaSedeAListaSedeDTO (List<Sede> listaSede);


}

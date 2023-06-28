package com.example.reservabackmathews.service;

import com.example.reservabackmathews.dtos.SedeDTO;
import com.example.reservabackmathews.mappers.SedeMapper;
import com.example.reservabackmathews.model.Sede;
import com.example.reservabackmathews.repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SedeServiceImpl  implements SedeService{

    @Autowired
    private SedeRepository sedeRepository;

    @Override
    public List<SedeDTO> listarSedes() {
        return SedeMapper.instance.listaSedeAListaSedeDTO( sedeRepository.findAll());
    }

    @Override
    public SedeDTO obtenerSedesPorID(long id) {
        Optional<Sede> sede= sedeRepository.findById(id);
        SedeDTO sedeDTO ;
        if(sede.isPresent()){
            sedeDTO = SedeMapper.instance.sedeASedeDTO(sede.get());
        }else {
            sedeDTO=null;
        }
        return  sedeDTO;
    }
}

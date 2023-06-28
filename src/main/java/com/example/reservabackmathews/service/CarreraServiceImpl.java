package com.example.reservabackmathews.service;

import com.example.reservabackmathews.dtos.AlumnoDTO;
import com.example.reservabackmathews.dtos.CarreraCreateDTO;
import com.example.reservabackmathews.dtos.CarreraDTO;
import com.example.reservabackmathews.dtos.CarreraUpdateDTO;
import com.example.reservabackmathews.mappers.AlumnoMapper;
import com.example.reservabackmathews.mappers.CarreraMapper;
import com.example.reservabackmathews.model.Alumno;
import com.example.reservabackmathews.model.Carrera;
import com.example.reservabackmathews.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarreraServiceImpl implements CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    @Override
    public List<CarreraDTO> listarCarreras() {
        return CarreraMapper.instance.listaCarreraAListaCarreraDTO( carreraRepository.findAll());
    }

    @Override
    public CarreraDTO obtenerCarreraPorID(long id) {
        Optional<Carrera> carrera= carreraRepository.findById(id);
        CarreraDTO carreraDTO ;
        if(carrera.isPresent()){
            carreraDTO = CarreraMapper.instance.carreraACarreraDTO(carrera.get());
        }else {
            carreraDTO=null;
        }
        return  carreraDTO;
    }

    @Override
    public CarreraDTO registrarCarrera(CarreraCreateDTO carreraCreateDTO) {
        Carrera carrera=CarreraMapper.instance.carreraCreatedDTOACarrera(carreraCreateDTO);
        Carrera respuestaEntity=carreraRepository.save(carrera);
        CarreraDTO respuestaDTO= CarreraMapper.instance.carreraACarreraDTO(respuestaEntity);
        return respuestaDTO;

    }

    @Override
    public CarreraDTO actualizarCarrera(CarreraUpdateDTO carreraUpdateDTO) {
        Carrera carrera=CarreraMapper.instance.carreraUpdateDTOACarrera(carreraUpdateDTO);
        Carrera respuestaEntity=carreraRepository.save(carrera);
        CarreraDTO respuestaDTO= CarreraMapper.instance.carreraACarreraDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public CarreraDTO eliminarCarrera(long id) {
        Optional<Carrera> carreraOptional= carreraRepository.findById(id);
        CarreraDTO carreraDTO = new CarreraDTO();
        String resultado ;
        if(carreraOptional.isPresent()){
            carreraDTO=CarreraMapper.instance.carreraACarreraDTO(carreraOptional.get());
            carreraRepository.delete(carreraOptional.get());
            return carreraDTO;
        }else {
            resultado="No se pudo realizar la eliminación";
        }
        return carreraDTO;
    }
}

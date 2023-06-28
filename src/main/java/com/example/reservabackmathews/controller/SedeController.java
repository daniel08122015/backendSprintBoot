package com.example.reservabackmathews.controller;

import com.example.reservabackmathews.dtos.CarreraDTO;
import com.example.reservabackmathews.dtos.SedeDTO;
import com.example.reservabackmathews.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SedeController {

    @Autowired

    private SedeService sedeService;

    @GetMapping("sedes")
    public ResponseEntity<List<SedeDTO>> listarCarrera(){
        return   new ResponseEntity<>(sedeService.listarSedes(), HttpStatus.OK);
    }

    @GetMapping("/sedes/{sedeId}")
    public ResponseEntity<SedeDTO> obtenerSedesPorId(@PathVariable("sedeId") long sedeId){
        return  new ResponseEntity<> ( sedeService.obtenerSedesPorID(sedeId),HttpStatus.OK);
    }
}

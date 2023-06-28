package com.example.reservabackmathews.controller;

import com.example.reservabackmathews.dtos.AlumnoCreateDTO;
import com.example.reservabackmathews.dtos.AlumnoDTO;
import com.example.reservabackmathews.dtos.AlumnoUpdateDTO;
import com.example.reservabackmathews.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;


    @GetMapping("alumnos")
    public ResponseEntity<List<AlumnoDTO>> listarAlumnos(){
        return   new ResponseEntity<>(alumnoService.listarAlumnos(), HttpStatus.OK);
    }

    @GetMapping("/alumnos/{alumnoId}")
    public ResponseEntity<AlumnoDTO> obtenerAlumnoPorId(@PathVariable("alumnoId") long alumnoId){
        return  new ResponseEntity<> ( alumnoService.obtenerAlumnoPorID(alumnoId),HttpStatus.OK);
    }

    @PostMapping("alumnos")
    public ResponseEntity<AlumnoDTO> registrarAlumno(@RequestBody AlumnoCreateDTO alumnoCreateDTO){
        return  new ResponseEntity <>( alumnoService.registrarAlumno(alumnoCreateDTO) ,HttpStatus.OK) ;
    }

    @PutMapping("alumnos")
    public ResponseEntity<AlumnoDTO> actualizarAlumno(@RequestBody AlumnoUpdateDTO alumnoUpdateDTO){
        return new ResponseEntity<>(alumnoService.actualizarAlumno(alumnoUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/alumnos/{alumnoId}")
    public ResponseEntity<AlumnoDTO> eliminarAlumno(@PathVariable("alumnoId") long alumnoId) {
        return new ResponseEntity<>( alumnoService.eliminarAlumno(alumnoId),HttpStatus.OK);
    }
}
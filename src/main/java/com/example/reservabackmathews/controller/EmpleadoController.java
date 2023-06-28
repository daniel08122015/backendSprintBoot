package com.example.reservabackmathews.controller;

import com.example.reservabackmathews.dtos.*;
import com.example.reservabackmathews.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("empleados")
    public ResponseEntity<List<EmpleadoDTO>> listarEmpleados(){
        return   new ResponseEntity<>(empleadoService.listarEmpleados(), HttpStatus.OK);
    }

    @GetMapping("/empleados/{empleadoId}")
    public ResponseEntity<EmpleadoDTO> obtenerEmpleadoPorId(@PathVariable("empleadoId") long empleadoId){
        return  new ResponseEntity<> ( empleadoService.obtenerEmpleadoPorID(empleadoId),HttpStatus.OK);
    }

    @PostMapping("empleados")
    public ResponseEntity<EmpleadoDTO> registrarEmpleado(@RequestBody EmpleadoCreateDTO empleadoCreateDTO){
        return  new ResponseEntity <>( empleadoService.registrarEmpleado(empleadoCreateDTO) ,HttpStatus.OK) ;
    }

    @PutMapping("empleados")
    public ResponseEntity<EmpleadoDTO> actualizarRegistro(@RequestBody EmpleadoUpdateDTO empleadoUpdateDTO){
        return new ResponseEntity<>(empleadoService.actualizarEmpleado(empleadoUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/empleados/{empleadoId}")
    public ResponseEntity<EmpleadoDTO> eliminarEmpleado(@PathVariable("empleadoId") long empleadoId) {
        return new ResponseEntity<>( empleadoService.eliminarAEmpleado(empleadoId),HttpStatus.OK);
    }
}

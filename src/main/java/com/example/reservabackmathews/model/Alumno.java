package com.example.reservabackmathews.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tb_alumno")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codAlumno;

    @Column(length = 100, nullable = false)
    private String nombres;

    @Column(length = 100, nullable = false)
    private String apePaterno;

    @Column(length = 100, nullable = false)
    private String apeMaterno;

    @Column(nullable = false)
    private Integer celular;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(name="fechaReserva", nullable = false)
    @Temporal(value=TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaReserva;

    @OneToOne()
    @JoinColumn(name="codSede")
    private Sede sede;

    @OneToOne()
    @JoinColumn(name="codCarrera")
    private Carrera carrera;
}

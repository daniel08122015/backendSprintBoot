package com.example.reservabackmathews.repository;

import com.example.reservabackmathews.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

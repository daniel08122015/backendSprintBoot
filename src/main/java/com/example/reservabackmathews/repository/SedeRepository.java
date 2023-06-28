package com.example.reservabackmathews.repository;

import com.example.reservabackmathews.model.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedeRepository extends JpaRepository<Sede,Long> {
}

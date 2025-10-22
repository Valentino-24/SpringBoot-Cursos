package com.example.trabajospringbootvalentino.repository;

import com.example.trabajospringbootvalentino.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> { }

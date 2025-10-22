package com.example.trabajospringbootvalentino.repository;

import com.example.trabajospringbootvalentino.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> { }

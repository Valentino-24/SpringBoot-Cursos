package com.example.trabajospringbootvalentino.service;

import com.example.trabajospringbootvalentino.dto.*;
import com.example.trabajospringbootvalentino.entity.*;
import com.example.trabajospringbootvalentino.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CursoService {

    private final CursoRepository cursoRepo;
    private final ProfesorRepository profesorRepo;
    private final EstudianteRepository estudianteRepo;

    public CursoService(CursoRepository cursoRepo, ProfesorRepository profesorRepo, EstudianteRepository estudianteRepo) {
        this.cursoRepo = cursoRepo;
        this.profesorRepo = profesorRepo;
        this.estudianteRepo = estudianteRepo;
    }

    public List<CursoDTO> listarCursos() {
        return cursoRepo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<Profesor> listarProfesores() { return profesorRepo.findAll(); }
    public List<Estudiante> listarEstudiantes() { return estudianteRepo.findAll(); }

    @Transactional
    public CursoDTO crearCursoConProfesor(CursoCreateDTO dto) {
        Profesor profesor = Profesor.builder()
                .nombre(dto.getProfesorNombre())
                .email(dto.getProfesorEmail())
                .build();

        Curso curso = Curso.builder()
                .nombre(dto.getNombre())
                .profesor(profesor)
                .build();

        Curso saved = cursoRepo.save(curso);
        return toDTO(saved);
    }

    @Transactional
    public CursoDTO asignarEstudiantes(Long cursoId, Set<Long> estudianteIds) {
        Curso curso = cursoRepo.findById(cursoId)
                .orElseThrow(() -> new NoSuchElementException("Curso no encontrado " + cursoId));

        Set<Estudiante> estudiantes = estudianteIds.stream()
                .map(id -> estudianteRepo.findById(id)
                        .orElseThrow(() -> new NoSuchElementException("Estudiante no encontrado " + id)))
                .collect(Collectors.toSet());

        curso.getEstudiantes().addAll(estudiantes);
        Curso saved = cursoRepo.save(curso);
        return toDTO(saved);
    }

    public List<CursoDTO> cursosDeEstudiante(Long estudianteId) {
        Estudiante est = estudianteRepo.findById(estudianteId)
                .orElseThrow(() -> new NoSuchElementException("Estudiante no encontrado " + estudianteId));
        return est.getCursos().stream().map(this::toDTO).collect(Collectors.toList());
    }

    private CursoDTO toDTO(Curso c) {
        Set<String> nombres = c.getEstudiantes().stream().map(Estudiante::getNombre).collect(Collectors.toSet());
        CursoDTO dto = new CursoDTO();
        dto.setId(c.getId());
        dto.setNombre(c.getNombre());
        if (c.getProfesor() != null) {
            dto.setProfesorNombre(c.getProfesor().getNombre());
            dto.setProfesorEmail(c.getProfesor().getEmail());
        }
        dto.setEstudiantesNombres(nombres);
        return dto;
    }
}

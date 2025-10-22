package com.example.trabajospringbootvalentino.controller;

import com.example.trabajospringbootvalentino.dto.*;
import com.example.trabajospringbootvalentino.entity.*;
import com.example.trabajospringbootvalentino.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("/cursos")
    public ResponseEntity<List<CursoDTO>> listarCursos() {
        return ResponseEntity.ok(cursoService.listarCursos());
    }

    @GetMapping("/profesores")
    public ResponseEntity<List<Profesor>> listarProfesores() {
        return ResponseEntity.ok(cursoService.listarProfesores());
    }

    @GetMapping("/estudiantes")
    public ResponseEntity<List<Estudiante>> listarEstudiantes() {
        return ResponseEntity.ok(cursoService.listarEstudiantes());
    }

    @PostMapping("/cursos")
    public ResponseEntity<CursoDTO> crearCurso(@RequestBody CursoCreateDTO dto) {
        CursoDTO creado = cursoService.crearCursoConProfesor(dto);
        return ResponseEntity.status(201).body(creado);
    }

    @PostMapping("/cursos/{id}/asignar-estudiantes")
    public ResponseEntity<CursoDTO> asignarEstudiantes(@PathVariable Long id, @RequestBody AsignarEstudiantesDTO dto) {
        CursoDTO actualizado = cursoService.asignarEstudiantes(id, dto.getEstudianteIds());
        return ResponseEntity.ok(actualizado);
    }

    @GetMapping("/estudiantes/{id}/cursos")
    public ResponseEntity<List<CursoDTO>> cursosDeEstudiante(@PathVariable Long id) {
        return ResponseEntity.ok(cursoService.cursosDeEstudiante(id));
    }
}

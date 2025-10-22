package com.example.trabajospringbootvalentino.dto;

import lombok.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {
    private Long id;
    private String nombre;
    private String profesorNombre;
    private String profesorEmail;
    private Set<String> estudiantesNombres;
}

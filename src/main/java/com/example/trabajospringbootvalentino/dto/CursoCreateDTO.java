package com.example.trabajospringbootvalentino.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoCreateDTO {
    private String nombre;
    private String profesorNombre;
    private String profesorEmail;
}

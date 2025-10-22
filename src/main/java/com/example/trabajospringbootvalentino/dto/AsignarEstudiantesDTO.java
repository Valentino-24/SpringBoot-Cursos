package com.example.trabajospringbootvalentino.dto;

import lombok.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignarEstudiantesDTO {
    private Set<Long> estudianteIds;
}

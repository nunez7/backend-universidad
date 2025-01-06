package com.vass.universidad.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarreraDTO {
    private Integer codigo;
    private String nombre;
    private Integer cantidad_materias;
    private Integer cantidad_cuatrimestres;

}

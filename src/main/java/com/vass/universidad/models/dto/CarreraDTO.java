package com.vass.universidad.models.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarreraDTO {
    private Integer codigo;

    @NotNull
    @NotEmpty(message = "Debes ingresar un valor de nombre")
    private String nombre;

    @Positive(message = "La cantidad de materias no puede ser negativo")
    private Integer cantidad_materias;

    @Positive(message = "La cantidad de cuatrimestres no puede ser negativo")
    private Integer cantidad_cuatrimestres;

}

package com.vass.universidad.models.dto;

import com.vass.universidad.models.entities.Direccion;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class PersonaDTO {

    private Integer id;
    private String nombre;
    private String apellidos;
    @Pattern(regexp = "[0-9]+")
    private Direccion direccion;

}

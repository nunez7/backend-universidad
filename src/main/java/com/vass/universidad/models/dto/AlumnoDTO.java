package com.vass.universidad.models.dto;

import com.vass.universidad.models.entities.Direccion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AlumnoDTO extends PersonaDTO{

    private String matricula;

    public AlumnoDTO(Integer id, String nombre, String apellido, Direccion direccion, String matricula) {
        super(id, nombre, apellido, direccion);
        this.matricula = matricula;
    }

}

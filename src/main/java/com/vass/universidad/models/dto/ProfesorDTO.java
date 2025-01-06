package com.vass.universidad.models.dto;

import com.vass.universidad.models.entities.Direccion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProfesorDTO extends PersonaDTO{

    private BigDecimal sueldo;

    public ProfesorDTO(Integer id, String nombre, String apellidos, Direccion direccion, BigDecimal sueldo) {
        super(id, nombre, apellidos, direccion);
        this.sueldo = sueldo;
    }

}

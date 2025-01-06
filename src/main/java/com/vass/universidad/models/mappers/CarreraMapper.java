package com.vass.universidad.models.mappers;

import com.vass.universidad.models.dto.CarreraDTO;
import com.vass.universidad.models.entities.Carrera;

public class CarreraMapper {

    public static CarreraDTO mapCarrera(Carrera carrera){
        CarreraDTO dto = new CarreraDTO();
        dto.setCodigo(carrera.getId());
        dto.setNombre(carrera.getNombre());
        dto.setCantidadCuatrimestres(carrera.getCantidadCuatrimestres());
        dto.setCantidadMaterias(carrera.getCantidadMaterias());
        return dto;
    }

}

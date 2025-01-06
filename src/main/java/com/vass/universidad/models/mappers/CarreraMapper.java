package com.vass.universidad.models.mappers;

import com.vass.universidad.models.dto.CarreraDTO;
import com.vass.universidad.models.entities.Carrera;

public class CarreraMapper {

    public static CarreraDTO mapCarrera(Carrera carrera){
        CarreraDTO dto = new CarreraDTO();
        dto.setCodigo(carrera.getId());
        dto.setNombre(carrera.getNombre());
        dto.setCantidad_cuatrimestres(carrera.getCantidadCuatrimestres());
        dto.setCantidad_materias(carrera.getCantidadMaterias());
        return dto;
    }

}

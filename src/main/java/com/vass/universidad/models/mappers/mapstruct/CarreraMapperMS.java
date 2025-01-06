package com.vass.universidad.models.mappers.mapstruct;

import com.vass.universidad.models.dto.CarreraDTO;
import com.vass.universidad.models.entities.Carrera;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CarreraMapperMS {

    @Mappings({
            @Mapping(source = "id", target = "codigo"),
            @Mapping(source = "cantidadMaterias", target = "cantidad_materias"),
            @Mapping(source = "cantidadCuatrimestres", target = "cantidad_cuatrimestres")
    })
    CarreraDTO mapCarrera(Carrera carrera);

}

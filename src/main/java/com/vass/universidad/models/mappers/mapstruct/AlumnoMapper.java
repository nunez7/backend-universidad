package com.vass.universidad.models.mappers.mapstruct;

import com.vass.universidad.models.dto.AlumnoDTO;
import com.vass.universidad.models.entities.Alumno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", config = AlumnoMapperConfig.class)
public abstract class AlumnoMapper {

    public abstract AlumnoDTO mapAlumno(Alumno alumno);

    @Mapping(target = "fechaAlta", ignore = true)
    @Mapping(target = "fechaModificacion", ignore = true)
    @Mapping(target = "carrera", ignore = true)
    public abstract Alumno mapAlumno(AlumnoDTO alumnoDTO);

}

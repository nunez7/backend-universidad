package com.vass.universidad.models.mappers.mapstruct;

import com.vass.universidad.models.dto.AlumnoDTO;
import com.vass.universidad.models.entities.Alumno;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = AlumnoMapperConfig.class)
public abstract class AlumnoMapper {

    public abstract AlumnoDTO mapAlumno(Alumno alumno);
    public abstract Alumno mapAlumno(AlumnoDTO alumnoDTO);

}

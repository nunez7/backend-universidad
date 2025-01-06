package com.vass.universidad.models.mappers.mapstruct;

import com.vass.universidad.models.dto.AlumnoDTO;
import com.vass.universidad.models.entities.Alumno;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface AlumnoMapperConfig extends PersonaMapperConfig{

    @InheritConfiguration(name = "mapPersona")
    void mapAlumno (Alumno alumno, @MappingTarget AlumnoDTO alumnoDTO);

}


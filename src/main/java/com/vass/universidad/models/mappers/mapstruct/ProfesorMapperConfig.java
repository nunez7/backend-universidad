package com.vass.universidad.models.mappers.mapstruct;
import com.vass.universidad.models.dto.ProfesorDTO;
import com.vass.universidad.models.entities.Profesor;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;
@MapperConfig
public interface ProfesorMapperConfig extends PersonaMapperConfig{

    @InheritConfiguration(name = "mapPersona")
    void mapProfesor(Profesor profesor, @MappingTarget ProfesorDTO profesorDTO);

}
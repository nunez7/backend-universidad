package com.vass.universidad.models.mappers.mapstruct;

import com.vass.universidad.models.dto.PersonaDTO;
import com.vass.universidad.models.entities.Persona;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface PersonaMapperConfig {
    void mapPersona(Persona persona, @MappingTarget PersonaDTO personaDTO);
}

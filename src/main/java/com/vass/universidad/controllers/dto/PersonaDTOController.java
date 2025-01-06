package com.vass.universidad.controllers.dto;

import com.vass.universidad.models.dto.PersonaDTO;
import com.vass.universidad.models.entities.Alumno;
import com.vass.universidad.models.entities.Empleado;
import com.vass.universidad.models.entities.Persona;
import com.vass.universidad.models.entities.Profesor;
import com.vass.universidad.models.mappers.mapstruct.AlumnoMapper;
import com.vass.universidad.services.contract.PersonaService;

import java.util.Optional;

public class PersonaDTOController extends GenericDTOController<Persona, PersonaService> {

    protected final AlumnoMapper alumnoMapper;

    public PersonaDTOController(PersonaService service, String nombreEntidad, AlumnoMapper alumnoMapper) {
        super(service, nombreEntidad);
        this.alumnoMapper = alumnoMapper;
    }

    public PersonaDTO altaPersona(Persona persona) {
        Persona personaEntidad = super.altaEntidad(persona);
        PersonaDTO dto = null;
        if(personaEntidad instanceof Alumno) {
            dto = alumnoMapper.mapAlumno((Alumno) personaEntidad);
        } else if (personaEntidad instanceof Profesor) {
            //aplicariamos mapper de profesor
        } else if (personaEntidad instanceof Empleado) {
            //aplicamos el mapper de empelado
        }
        return dto;
    }

    public PersonaDTO buscarPersonaPorId(Integer id) {
        Optional<Persona> oPersona = super.obtenerPorId(id);
        Persona persona;
        PersonaDTO dto = null;
        if(oPersona.isEmpty()){
            return null;
        } else {
            persona = oPersona.get();
        }
        if(persona instanceof Alumno) {
            dto = alumnoMapper.mapAlumno((Alumno) persona);
        } else if (persona instanceof Profesor) {
            //aplicariamos mapper de profesor
        } else if (persona instanceof Empleado) {
            //aplicamos el mapper de empelado
        }
        return dto;
    }
}

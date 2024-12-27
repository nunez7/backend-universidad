package com.vass.universidad.services.implementation;

import com.vass.universidad.entities.Persona;
import com.vass.universidad.repositories.PersonaRepository;
import com.vass.universidad.services.contract.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl extends GenericServiceImpl<Persona, PersonaRepository> implements AlumnoService {

    @Autowired
    public AlumnoServiceImpl(@Qualifier("repositorioAlumnos") PersonaRepository repository) {
        super(repository);
    }
}

package com.vass.universidad.services.implementation;

import com.vass.universidad.entities.Persona;
import com.vass.universidad.repositories.AlumnoRepository;
import com.vass.universidad.repositories.PersonaRepository;
import com.vass.universidad.services.contract.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnoServiceImpl extends PersonaServiceImpl implements AlumnoService {

    @Autowired
    public AlumnoServiceImpl(@Qualifier("repositorioAlumnos") PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly =true)
    public Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre) {
        return ((AlumnoRepository) repository).buscarAlumnosPorNombreCarrera(nombre);
    }
}

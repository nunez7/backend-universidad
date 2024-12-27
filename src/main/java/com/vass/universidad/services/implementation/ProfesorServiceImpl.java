package com.vass.universidad.services.implementation;


import com.vass.universidad.entities.Persona;
import com.vass.universidad.repositories.PersonaRepository;
import com.vass.universidad.repositories.ProfesorRepository;
import com.vass.universidad.services.contract.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfesorServiceImpl extends PersonaServiceImpl implements ProfesorService {

    @Autowired
    public ProfesorServiceImpl(@Qualifier("profesorRepository") PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly =true)
    public Iterable<Persona> findProfesoresByCarrera(String nombre) {
        return ((ProfesorRepository)repository).findProfesoresByCarrera(nombre);
    }
}

package com.vass.universidad.services.implementation;

import com.vass.universidad.entities.Persona;
import com.vass.universidad.repositories.PersonaRepository;
import com.vass.universidad.services.contract.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    @Autowired
    @Qualifier("repositorioAlumnos")
    private PersonaRepository repository;


    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Persona save(Persona alumno) {
        return repository.save(alumno);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}

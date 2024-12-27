package com.vass.universidad.services.contract;

import com.vass.universidad.entities.Persona;

import java.util.Optional;

public interface PersonaService {
    Optional<Persona> findById(Integer id);
    Persona save(Persona alumno);
    Iterable<Persona> findAll();
    void deleteById(Integer id);
}

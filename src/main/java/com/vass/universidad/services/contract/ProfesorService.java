package com.vass.universidad.services.contract;

import com.vass.universidad.models.entities.Persona;

public interface ProfesorService extends PersonaService{
    Iterable<Persona> findProfesoresByCarrera(String nombre);
}

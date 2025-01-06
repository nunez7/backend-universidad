package com.vass.universidad.services.contract;

import com.vass.universidad.models.entities.Persona;

import java.util.Optional;

public interface PersonaService extends GenericService<Persona> {
    Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);
    Iterable<Persona> buscarPersonaPorApellido(String apellido);
}

package com.vass.universidad.services.implementation;

import com.vass.universidad.entities.Persona;
import com.vass.universidad.repositories.PersonaRepository;
import com.vass.universidad.services.contract.PersonaService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class PersonaServiceImpl extends GenericServiceImpl<Persona, PersonaRepository> implements PersonaService {

    public PersonaServiceImpl(PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido) {
        return repository.buscarPorNombreYApellidos(nombre, apellido);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarPersonaPorApellido(String apellido) {
        return repository.buscarPersonaPorApellidos(apellido);
    }
}

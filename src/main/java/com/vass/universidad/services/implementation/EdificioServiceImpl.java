package com.vass.universidad.services.implementation;

import com.vass.universidad.entities.Edificio;
import com.vass.universidad.repositories.EdificioRepository;
import com.vass.universidad.services.contract.EdificioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EdificioServiceImpl extends GenericServiceImpl<Edificio, EdificioRepository> implements EdificioService {


    @Autowired
    public EdificioServiceImpl(EdificioRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly =true)
    public Iterable<Edificio> findEdificioByLocalidad(String localidad) {
        return repository.findEdificioByDireccion_Localidad(localidad);
    }

    @Override
    @Transactional(readOnly =true)
    public Optional<Edificio> findEdificioByDescripcionIgnoreCase(String nombre) {
        return repository.findEdificioByDescripcionIgnoreCase(nombre);
    }

    @Override
    @Transactional(readOnly =true)
    public Iterable<Edificio> findEdificioByFechaAltaBetween(LocalDateTime desde, LocalDateTime hasta) {
        return repository.findEdificioByFechaAltaBetween(desde, hasta);
    }
}

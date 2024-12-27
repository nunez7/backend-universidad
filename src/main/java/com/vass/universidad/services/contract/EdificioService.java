package com.vass.universidad.services.contract;

import com.vass.universidad.entities.Edificio;

import java.time.LocalDateTime;
import java.util.Optional;

public interface EdificioService extends GenericService<Edificio>{
    Iterable<Edificio> findEdificioByLocalidad(String localidad);
    Optional<Edificio> findEdificioByDescripcionIgnoreCase(String nombre);
    Iterable<Edificio> findEdificioByFechaAltaBetween(LocalDateTime desde, LocalDateTime hasta);
}

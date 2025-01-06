package com.vass.universidad.repositories;

import com.vass.universidad.models.entities.Edificio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface EdificioRepository extends CrudRepository<Edificio, Integer> {
    Iterable<Edificio> findEdificioByDireccion_Localidad(String localidad);
    Optional<Edificio> findEdificioByDescripcionIgnoreCase(String nombre);
    Iterable<Edificio> findEdificioByFechaAltaBetween(LocalDateTime desde, LocalDateTime hasta);
}

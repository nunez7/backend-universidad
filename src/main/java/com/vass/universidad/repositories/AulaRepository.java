package com.vass.universidad.repositories;

import com.vass.universidad.entities.Aula;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AulaRepository  extends CrudRepository<Aula, Integer> {
    Optional<Aula> findAulaByAbreviatura(String abreviatura);
    Iterable<Aula> findAulasByEdificio_Descripcion(String nombre);
}

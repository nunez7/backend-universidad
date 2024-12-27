package com.vass.universidad.services.contract;

import com.vass.universidad.entities.Aula;

import java.util.Optional;

public interface AulaService extends GenericService<Aula>{
    Optional<Aula> findAulaByAbreviatura(String abreviatura);
    Iterable<Aula> findAulasByEdificio_Descripcion(String nombre);
}

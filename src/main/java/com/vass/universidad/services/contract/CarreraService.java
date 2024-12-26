package com.vass.universidad.services.contract;

import com.vass.universidad.entities.Carrera;

import java.util.Optional;

public interface CarreraService {
    Optional<Carrera> findById(Integer id);
    Carrera save(Carrera carrera);

    Iterable<Carrera> findAll();

    void deleteById(Integer id);

}

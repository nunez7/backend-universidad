package com.vass.universidad.services.contract;

import java.util.Optional;

public interface GenericService <E> {
    Optional<E> findById(Integer id);
    E save(E entidad);
    Iterable<E> findAll();
    void deleteById(Integer id);
}

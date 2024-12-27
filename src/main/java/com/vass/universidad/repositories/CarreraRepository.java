package com.vass.universidad.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vass.universidad.entities.Carrera;

@Repository
public interface CarreraRepository extends CrudRepository<Carrera, Integer>{

    Iterable<Carrera> findCarrerasByNombreContains(String nombre);
    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
    Iterable<Carrera> findCarrerasByCantidadCuatrimestresAfter(Integer cantidadCuatrimestres);

}
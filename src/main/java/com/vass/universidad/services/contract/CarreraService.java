package com.vass.universidad.services.contract;

import com.vass.universidad.models.entities.Carrera;

public interface CarreraService extends GenericService<Carrera>{

    Iterable<Carrera> findCarrerasByNombreContains(String nombre);
    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
    Iterable<Carrera> findCarrerasByCantidadCuatrimestresAfter(Integer cantidadCuatrimestres);

}

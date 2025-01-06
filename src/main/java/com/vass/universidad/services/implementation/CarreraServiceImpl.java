package com.vass.universidad.services.implementation;

import com.vass.universidad.models.entities.Carrera;
import com.vass.universidad.repositories.CarreraRepository;
import com.vass.universidad.services.contract.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarreraServiceImpl extends GenericServiceImpl<Carrera, CarreraRepository> implements CarreraService {

    @Autowired
    public CarreraServiceImpl(CarreraRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByNombreContains(String nombre) {
        return repository.findCarrerasByNombreContains(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre) {
        return repository.findCarrerasByNombreContainsIgnoreCase(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByCantidadCuatrimestresAfter(Integer cantidadCuatrimestres) {
        return repository.findCarrerasByCantidadCuatrimestresAfter(cantidadCuatrimestres);
    }

}

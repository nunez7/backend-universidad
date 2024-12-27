package com.vass.universidad.services.implementation;

import com.vass.universidad.entities.Carrera;
import com.vass.universidad.repositories.CarreraRepository;
import com.vass.universidad.services.contract.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarreraServiceImpl extends GenericServiceImpl<Carrera, CarreraRepository> implements CarreraService {

    @Autowired
    public CarreraServiceImpl(CarreraRepository repository) {
        super(repository);
    }

}

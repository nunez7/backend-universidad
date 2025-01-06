package com.vass.universidad.services.implementation;

import com.vass.universidad.models.entities.Aula;
import com.vass.universidad.repositories.AulaRepository;
import com.vass.universidad.services.contract.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AulaServiceImpl extends GenericServiceImpl<Aula, AulaRepository> implements AulaService {

    @Autowired
    public AulaServiceImpl(AulaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly =true)
    public Optional<Aula> findAulaByAbreviatura(String abreviatura) {
        return repository.findAulaByAbreviatura(abreviatura);
    }

    @Override
    @Transactional(readOnly =true)
    public Iterable<Aula> findAulasByEdificio_Descripcion(String nombre) {
        return repository.findAulasByEdificio_Descripcion(nombre);
    }
}

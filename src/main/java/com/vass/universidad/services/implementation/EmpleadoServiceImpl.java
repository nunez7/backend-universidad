package com.vass.universidad.services.implementation;

import com.vass.universidad.models.entities.Persona;
import com.vass.universidad.enums.TipoEmpleado;
import com.vass.universidad.repositories.EmpleadoRepository;
import com.vass.universidad.repositories.PersonaRepository;
import com.vass.universidad.services.contract.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadoServiceImpl extends PersonaServiceImpl implements EmpleadoService {

    @Autowired
    public EmpleadoServiceImpl(@Qualifier("empleadoRepository")  PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly =true)
    public Iterable<Persona> findEmpleadosByTipo(TipoEmpleado tipo) {
        return ((EmpleadoRepository) repository).findEmpleadoByTipoEmpleado(tipo);
    }
}

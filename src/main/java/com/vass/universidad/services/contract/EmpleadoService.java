package com.vass.universidad.services.contract;

import com.vass.universidad.models.entities.Persona;
import com.vass.universidad.enums.TipoEmpleado;

public interface EmpleadoService extends PersonaService{
    Iterable<Persona> findEmpleadosByTipo(TipoEmpleado tipo);
}

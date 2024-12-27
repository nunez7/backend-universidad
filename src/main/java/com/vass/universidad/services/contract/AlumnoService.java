package com.vass.universidad.services.contract;

import com.vass.universidad.entities.Persona;

public interface AlumnoService extends PersonaService{
    Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre);
}

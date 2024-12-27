package com.vass.universidad.repositories;

import com.vass.universidad.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface PersonaRepository extends CrudRepository<Persona, Integer> {

    @Query("select p from Persona p where p.nombre = ?1 and p.apellidos = ?2")
    Optional<Persona> buscarPorNombreYApellidos(String nombre, String apellido);

    @Query("select p from Persona p where p.apellidos like %?1%")
    Iterable<Persona> buscarPersonaPorApellidos(String apellido);

}

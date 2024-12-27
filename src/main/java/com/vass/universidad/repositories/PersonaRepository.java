package com.vass.universidad.repositories;

import com.vass.universidad.entities.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonaRepository extends CrudRepository<Persona, Integer> {

}

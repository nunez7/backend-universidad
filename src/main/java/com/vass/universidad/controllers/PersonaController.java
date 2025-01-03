package com.vass.universidad.controllers;


import com.vass.universidad.entities.Persona;
import com.vass.universidad.services.contract.PersonaService;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public class PersonaController extends GenericController<Persona, PersonaService> {

    public PersonaController(PersonaService service){
        super(service);
    }

    @GetMapping("/nombre-apellido")
    public Persona buscarPersonaPorNombreYApellido(@RequestParam String nombre, @RequestParam String apellido) throws BadRequestException {
        Optional<Persona> oPersona = service.buscarPorNombreYApellido(nombre, apellido);
        if(!oPersona.isPresent()) {
            throw new BadRequestException(String.format("No se encontro Persona con nombre %s y apellido %s", nombre, apellido));
        }
        return oPersona.get();
    }
}

package com.vass.universidad.controllers;


import com.vass.universidad.models.entities.Persona;
import com.vass.universidad.services.contract.PersonaService;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PersonaController extends GenericController<Persona, PersonaService> {

    public PersonaController(PersonaService service){
        super(service);
    }

    @GetMapping("/nombre-apellido")
    public ResponseEntity<?> buscarPersonaPorNombreYApellido(@RequestParam String nombre, @RequestParam String apellido) throws BadRequestException {
        Optional<Persona> oPersona = service.buscarPorNombreYApellido(nombre, apellido);
        Map<String, Object> mensaje = new HashMap<>();
        if(!oPersona.isPresent()) {
            //throw new BadRequestException(String.format("No se encontro Persona con nombre %s y apellido %s", nombre, apellido));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("No se encontro Persona con nombre %s y apellido %s", nombre, apellido));
            return ResponseEntity.badRequest().body(mensaje);
        }
        mensaje.put("success", Boolean.TRUE);
        mensaje.put("datos", oPersona.get());
        return ResponseEntity.ok(mensaje);
    }
}

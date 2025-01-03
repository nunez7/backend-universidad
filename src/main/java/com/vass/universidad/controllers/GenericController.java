package com.vass.universidad.controllers;

import com.vass.universidad.entities.Persona;
import com.vass.universidad.services.contract.GenericService;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public class GenericController <E, S extends GenericService<E>>{

    protected final S service;
    protected String nombreEntidad;

    public GenericController(S service) {
        this.service = service;
    }

    @GetMapping
    public List<E> obtenerTodos() throws BadRequestException {
        List<E> listado = (List<E>) service.findAll();
        if(listado.isEmpty()) {
            throw new BadRequestException(String.format("No se han encontrado %ss", nombreEntidad));
        }
        return listado;
    }

    //obtenerPorID (Id)
    @GetMapping("/{id}")
    public E obtenerPorId(@PathVariable(required = false) Integer id) throws BadRequestException {
        Optional<E> verificaExistencia = service.findById(id);
        if(!verificaExistencia.isPresent()) {
            throw new BadRequestException(String.format("No existe id de %ss", nombreEntidad));
        }
        return verificaExistencia.get();
    }

    //borrarEntidadPorId (Id)
    @DeleteMapping("/{id}")
    public void eliminarEntidad(@PathVariable Integer id) {
        service.deleteById(id);
    }

    //altaEntidad (Entidad)

}

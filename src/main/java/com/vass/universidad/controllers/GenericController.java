package com.vass.universidad.controllers;

import com.vass.universidad.services.contract.GenericService;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GenericController <E, S extends GenericService<E>>{

    protected final S service;
    protected String nombreEntidad;

    public GenericController(S service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodos() throws BadRequestException {
        Map<String, Object> mensaje = new HashMap<>();
        List<E> listado = (List<E>) service.findAll();
        if(listado.isEmpty()) {
            //throw new BadRequestException(String.format("No se han encontrado %ss", nombreEntidad));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("No existen %ss", nombreEntidad));
            return ResponseEntity.badRequest().body(mensaje);
        }
        mensaje.put("success", Boolean.TRUE);
        mensaje.put("datos", listado);
        return ResponseEntity.ok(mensaje);
    }

    //obtenerPorID (Id)
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable(required = false) Integer id) throws BadRequestException {
        Optional<E> verificaExistencia = service.findById(id);
        Map<String, Object> mensaje = new HashMap<>();
        if(!verificaExistencia.isPresent()) {
            //throw new BadRequestException(String.format("No existe id de %ss", nombreEntidad));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("No existen id de %ss", nombreEntidad));
            return ResponseEntity.badRequest().body(mensaje);
        }
        mensaje.put("success", Boolean.TRUE);
        mensaje.put("datos", verificaExistencia);
        return ResponseEntity.ok(mensaje);
    }

    //borrarEntidadPorId (Id)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEntidad(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //altaEntidad (Entidad)

}

package com.vass.universidad.controllers.dto;

import com.vass.universidad.services.contract.GenericService;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class GenericDTOController <E, S extends GenericService<E>>{

    protected final S service;
    protected final String nombreEntidad;

    public List<E> obtenerTodos(){
        return (List<E>) service.findAll();
    }

    public Optional<E> obtenerPorId(Integer id){
        return (Optional<E>) service.findById(id);
    }

    public E altaEntidad(E entidad){
        return service.save(entidad);
    }

    protected Map<String, Object> obtenerValidaciones(BindingResult result){
        Map<String, Object> validaciones = new HashMap<>();
        result.getFieldErrors()
                .forEach(error -> validaciones.put(error.getField(), error.getDefaultMessage()));
        return validaciones;
    }

}

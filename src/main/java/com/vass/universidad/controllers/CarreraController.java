package com.vass.universidad.controllers;

import com.vass.universidad.models.entities.Carrera;
import com.vass.universidad.services.contract.CarreraService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Deprecated
@RestController
@RequestMapping("/carreras")
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "false")
public class CarreraController extends GenericController<Carrera, CarreraService>{

    @Autowired
    public CarreraController(CarreraService service) {
        super(service);
        nombreEntidad = "Carrera";
    }

    @PostMapping
    public ResponseEntity<?> altaCarrera(@RequestBody Carrera carrera, BindingResult result) throws BadRequestException {
        Map<String, Object> validaciones = new HashMap<>();
        if(result.hasErrors()) {
            result.getFieldErrors()
                    .forEach(error -> validaciones.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(validaciones);
        }
        return ResponseEntity.ok(service.save(carrera));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCarrera(@PathVariable Integer id, @RequestBody Carrera carrera) throws BadRequestException {
        Carrera carreraUpdate = null;
        Map<String, Object> mensaje = new HashMap<>();
        Optional<Carrera> oCarrera = service.findById(id);
        if(!oCarrera.isPresent()){
            //throw new BadRequestException(String.format("La carrera con id %d no existe", id));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("%s con ID %d no existe", nombreEntidad, id));
            return ResponseEntity.badRequest().body(mensaje);
        }
        carreraUpdate = oCarrera.get();
        carreraUpdate.setCantidadCuatrimestres(carrera.getCantidadCuatrimestres());
        carreraUpdate.setCantidadMaterias(carrera.getCantidadMaterias());

        mensaje.put("datos", service.save(carreraUpdate));
        mensaje.put("success", Boolean.TRUE);

        return ResponseEntity.ok(mensaje);
    }

}

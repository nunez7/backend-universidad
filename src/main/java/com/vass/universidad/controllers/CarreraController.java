package com.vass.universidad.controllers;

import com.vass.universidad.entities.Carrera;
import com.vass.universidad.exception.BatRequestException;
import com.vass.universidad.services.contract.CarreraService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/carreras")
public class CarreraController extends GenericController<Carrera, CarreraService>{

    @Autowired
    public CarreraController(CarreraService service) {
        super(service);
        nombreEntidad = "Carrera";
    }

    @PostMapping
    public ResponseEntity<?> altaCarrera(@RequestBody Carrera carrera) throws BadRequestException {
        Map<String, Object> mensaje = new HashMap<>();
        if(carrera.getCantidadCuatrimestres() < 0) {
            //throw new BadRequestException("El campo cantida de cuatrimestres no puede ser negativo");
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", "El campo cantida de cuatrimestres no puede ser negativo");
            return ResponseEntity.badRequest().body(mensaje);
        }
        if(carrera.getCantidadMaterias() < 0) {
            //throw new BadRequestException("El campo cantida de materias no puede ser negativo");
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", "El campo cantida de materias no puede ser negativo");
            return ResponseEntity.badRequest().body(mensaje);
        }

        mensaje.put("success", Boolean.TRUE);
        mensaje.put("datos", service.save(carrera));
        return ResponseEntity.ok(mensaje);
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

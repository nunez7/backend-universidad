package com.vass.universidad.controllers;

import com.vass.universidad.entities.Carrera;
import com.vass.universidad.exception.BatRequestException;
import com.vass.universidad.services.contract.CarreraService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public Carrera altaCarrera(@RequestBody Carrera carrera) throws BadRequestException {
        if(carrera.getCantidadCuatrimestres() < 0) {
            throw new BadRequestException("El campo cantida de cuatrimestres no puede ser negativo");
        }
        if(carrera.getCantidadMaterias() < 0) {
            throw new BadRequestException("El campo cantida de materias no puede ser negativo");
        }
        return service.save(carrera);
    }

    @PutMapping("/{id}")
    public Carrera actualizarCarrera(@PathVariable Integer id, @RequestBody Carrera carrera) throws BadRequestException {
        Carrera carreraUpdate = null;
        Optional<Carrera> oCarrera = service.findById(id);
        if(!oCarrera.isPresent()){
            throw new BadRequestException(String.format("La carrera con id %d no existe", id));
        }
        carreraUpdate = oCarrera.get();
        carreraUpdate.setCantidadCuatrimestres(carrera.getCantidadCuatrimestres());
        carreraUpdate.setCantidadMaterias(carrera.getCantidadMaterias());
        return service.save(carreraUpdate);
    }

}

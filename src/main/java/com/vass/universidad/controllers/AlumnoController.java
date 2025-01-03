package com.vass.universidad.controllers;

import com.vass.universidad.entities.Alumno;
import com.vass.universidad.entities.Carrera;
import com.vass.universidad.entities.Persona;
import com.vass.universidad.services.contract.CarreraService;
import com.vass.universidad.services.contract.PersonaService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    private final PersonaService personaService;

    private final CarreraService carreraService;

    @Autowired
    public AlumnoController(@Qualifier("alumnoServiceImpl")  PersonaService personaService, CarreraService carreraService) {
        this.personaService = personaService;
        this.carreraService = carreraService;
    }

    @PostMapping
    public Persona altaAlumno(@RequestBody Persona alumno){
        return personaService.save(alumno);
    }

    @GetMapping
    public List<Persona> obtenerTodos() throws BadRequestException {
        List<Persona> alumnos = (List<Persona>) personaService.findAll();
        if(alumnos.isEmpty()){
            throw new BadRequestException("No existe alumnos");
        }
        return alumnos;
    }

    @GetMapping("/{id}")
    public Persona obtenerAlumnoPorId(@PathVariable(required = false) Integer id) throws BadRequestException {
        Optional<Persona> oAlumno = personaService.findById(id);
        if(!oAlumno.isPresent()) {
            throw new BadRequestException(String.format("Alumno con id %d no existe", id));
        }
        return oAlumno.get();
    }

    @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable Integer id){
        personaService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Persona actualizarAlumno(@PathVariable Integer id, @RequestBody Persona alumno) throws BadRequestException {
        Persona alumnoUpdate = null;
        Optional<Persona> oAlumno = personaService.findById(id);
        if(!oAlumno.isPresent()) {
            throw new BadRequestException(String.format("Alumno con id %d no existe", id));
        }
        alumnoUpdate = oAlumno.get();
        alumnoUpdate.setNombre(alumno.getNombre());
        alumnoUpdate.setApellidos(alumno.getApellidos());
        alumnoUpdate.setDireccion(alumno.getDireccion());
        return personaService.save(alumnoUpdate);
    }

    @PutMapping("/{idAlumno}/carrera/{idCarrera}")
    public Persona asignarCarreraAlumno(@PathVariable Integer idAlumno, @PathVariable Integer idCarrera) throws BadRequestException {
        Optional<Persona> oAlumno = personaService.findById(idAlumno);
        if(!oAlumno.isPresent()) {
            throw new BadRequestException(String.format("Alumno con id %d no existe", idAlumno));
        }

        Optional<Carrera> oCarrera = carreraService.findById(idCarrera);
        if(!oCarrera.isPresent()){
            throw new BadRequestException(String.format("Carrera con id %d no existe", idCarrera));
        }

        Persona alumno = oAlumno.get();
        Carrera carrera = oCarrera.get();

        ((Alumno)alumno).setCarrera(carrera);

        return personaService.save(alumno);
    }
}

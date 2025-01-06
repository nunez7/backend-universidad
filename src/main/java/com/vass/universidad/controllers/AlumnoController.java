package com.vass.universidad.controllers;

import com.vass.universidad.models.entities.Alumno;
import com.vass.universidad.models.entities.Carrera;
import com.vass.universidad.models.entities.Persona;
import com.vass.universidad.services.contract.CarreraService;
import com.vass.universidad.services.contract.PersonaService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Deprecated
@RestController
@RequestMapping("/alumnos")
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "false")
public class AlumnoController extends PersonaController{

    private final CarreraService carreraService;

    @Autowired
    public AlumnoController(@Qualifier("alumnoServiceImpl")  PersonaService personaService, CarreraService carreraService) {
        super(personaService);
        nombreEntidad = "Alumno";
        this.carreraService = carreraService;
    }

    /*@PostMapping
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
    }*/

    /*@DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable Integer id){
        personaService.deleteById(id);
    }*/

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarAlumno(@PathVariable Integer id, @RequestBody Persona alumno) throws BadRequestException {
        Persona alumnoUpdate = null;
        Map<String, Object> mensaje = new HashMap<>();
        Optional<Persona> oAlumno = service.findById(id);
        if(!oAlumno.isPresent()) {
            //throw new BadRequestException(String.format("Alumno con id %d no existe", id));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("Alumno con id %d no existe", id));
            return ResponseEntity.badRequest().body(mensaje);
        }
        alumnoUpdate = oAlumno.get();
        alumnoUpdate.setNombre(alumno.getNombre());
        alumnoUpdate.setApellidos(alumno.getApellidos());
        alumnoUpdate.setDireccion(alumno.getDireccion());
        mensaje.put("datos", service.save(alumnoUpdate));
        mensaje.put("success", Boolean.TRUE);

        return ResponseEntity.ok(mensaje);
    }

    @PutMapping("/{idAlumno}/carrera/{idCarrera}")
    public ResponseEntity<?> asignarCarreraAlumno(@PathVariable Integer idAlumno, @PathVariable Integer idCarrera) throws BadRequestException {
        Optional<Persona> oAlumno = service.findById(idAlumno);
        Map<String, Object> mensaje = new HashMap<>();
        if(!oAlumno.isPresent()) {
            //throw new BadRequestException(String.format("Alumno con id %d no existe", idAlumno));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("Alumno con id %d no existe", idAlumno));
            return ResponseEntity.badRequest().body(mensaje);
        }

        Optional<Carrera> oCarrera = carreraService.findById(idCarrera);
        if(!oCarrera.isPresent()){
            //throw new BadRequestException(String.format("Carrera con id %d no existe", idCarrera));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("Carrera con id %d no existe", idCarrera));
            return ResponseEntity.badRequest().body(mensaje);
        }

        Persona alumno = oAlumno.get();
        Carrera carrera = oCarrera.get();

        ((Alumno)alumno).setCarrera(carrera);

        mensaje.put("datos", service.save(alumno));
        mensaje.put("success", Boolean.TRUE);
        return ResponseEntity.ok(mensaje);
    }
}

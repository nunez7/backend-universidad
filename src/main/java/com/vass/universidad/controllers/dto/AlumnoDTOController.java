package com.vass.universidad.controllers.dto;

import com.vass.universidad.models.dto.AlumnoDTO;
import com.vass.universidad.models.dto.PersonaDTO;
import com.vass.universidad.models.entities.Alumno;
import com.vass.universidad.models.entities.Persona;
import com.vass.universidad.models.mappers.mapstruct.AlumnoMapper;
import com.vass.universidad.services.contract.PersonaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "true")
public class AlumnoDTOController {

    @Autowired
    @Qualifier("alumnoServiceImpl")
    private PersonaService service;

    @Autowired
    private AlumnoMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerAlumnoPorId(@PathVariable Integer id){
        Map<String, Object> mensaje = new HashMap<>();

        Optional<Persona> oPersona = service.findById(id);
        PersonaDTO dto = mapper.mapAlumno((Alumno) oPersona.get());

        if(dto == null) {
            mensaje.put("succes", Boolean.FALSE);
            mensaje.put("mensaje", "No existe el alumno con ese ID!");
            return ResponseEntity.badRequest().body(mensaje);
        }

        mensaje.put("success", Boolean.TRUE);
        mensaje.put("data", dto);

        return ResponseEntity.ok(mensaje);
    }

    @PostMapping
    public ResponseEntity<?> altaAlumno(@Valid @RequestBody PersonaDTO personaDTO, BindingResult result){
        Map<String, Object> mensaje = new HashMap<>();

        if(result.hasErrors()) {
            Map<String, Object> validaciones = new HashMap<>();
            result.getFieldErrors().forEach(error -> validaciones.put(error.getField(), error.getDefaultMessage()));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("validaciones", validaciones);
            return ResponseEntity.badRequest().body(mensaje);
        }

        Persona save = service.save(mapper.mapAlumno((AlumnoDTO) personaDTO));

        mensaje.put("succes", Boolean.TRUE);
        mensaje.put("data", mapper.mapAlumno((Alumno) save));

        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }

}

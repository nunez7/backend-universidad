package com.vass.universidad.commands;

import com.vass.universidad.models.entities.Carrera;
import com.vass.universidad.services.contract.CarreraService;
import com.vass.universidad.services.contract.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;

import java.util.Optional;

public class AlumnosCommand implements CommandLineRunner {

    @Autowired
    @Qualifier("alumnoServiceImpl")
    private PersonaService personaService;
    @Autowired
    private CarreraService carreraService;

    @Override
    public void run(String... args) throws Exception {
        Optional<Carrera> ingSistemas = carreraService.findById(1);

        /*Iterable<Persona> alumnos = personaService.findAll();
        alumnos.forEach(alumno -> ((Alumno)alumno).setCarrera(ingSistemas.get()));
        alumnos.forEach(alumno -> personaService.save(alumno));

        Optional<Persona> alumno = personaService.findById(1);
        Optional<Persona> personaNomApe = personaService.buscarPorNombreYApellido(alumno.get().getNombre(), alumno.get().getApellidos());
        System.out.println(personaNomApe.toString());

        Iterable<Persona> personasApellido = personaService.buscarPersonaPorApellido(alumno.get().getApellidos());
        personasApellido.forEach(System.out::println);

        Iterable<Persona> alumnosCarrera = ((AlumnoService) personaService).buscarAlumnosPorNombreCarrera(ingSistemas.get().getNombre());
        alumnosCarrera.forEach(System.out::println);*/
    }
}

package com.vass.universidad.commands;

import com.vass.universidad.models.entities.Carrera;
import com.vass.universidad.services.contract.CarreraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CarreraCommando implements CommandLineRunner {

    @Autowired
    private CarreraService carreraService;

    private static final Logger logger = LoggerFactory.getLogger(CarreraCommando.class);

    @Override
    public void run(String... args) throws Exception {
        /*Carrera inSistemas = new Carrera(null, "Ingenieria en Sistemas", 12, 8);
        Carrera cSave = carreraService.save(inSistemas);
        System.out.println(cSave.toString());*/


        //Para Generics
        Optional<Carrera> oCarrera = carreraService.findById(1);
        if(oCarrera.isPresent()){
            Carrera carrera = oCarrera.get();
            logger.info("Carrera {}", carrera.getNombre());
        }else {
            logger.info("Carrera no encontrada");
        }

        /*Carrera ingIndustrial = new Carrera(null, "Ingenieria Industrial", 55, 5);
        Carrera ingAlimentos = new Carrera(null, "Ingenieria en Alimentos", 53, 5);
        Carrera ingElectronica = new Carrera(null, "Ingenieria Electronica", 45, 5);
        Carrera licSistemas = new Carrera(null, "Licenciatura en Sistemas", 40, 4);
        Carrera licTurismo = new Carrera(null, "Licenciatura en Turismo", 42, 4);
        Carrera licYoga = new Carrera(null, "Licenciatura en Yoga", 25, 3);
        Carrera licRecursos = new Carrera(null, "Licenciatura en Recursos Humanos - RRHH", 33, 3);

        carreraService.save(ingIndustrial);
        carreraService.save(ingAlimentos);
        carreraService.save(ingElectronica);
        carreraService.save(licSistemas);
        carreraService.save(licTurismo);
        carreraService.save(licYoga);
        carreraService.save(licRecursos);

        List<Carrera> carreras = (List<Carrera>)carreraService.findCarrerasByNombreContains("Sistemas");
        carreras.forEach(System.out::println);

        List<Carrera> carrerasIgnoreCase1 = (List<Carrera>) carreraService.findCarrerasByNombreContainsIgnoreCase("SISTEMAS");
        List<Carrera> carrerasIgnoreCase2 = (List<Carrera>) carreraService.findCarrerasByNombreContainsIgnoreCase("sistemas");
        carrerasIgnoreCase1.forEach(System.out::println);
        carrerasIgnoreCase2.forEach(System.out::println);

        List<Carrera> carrerasPorAnio = (List<Carrera>) carreraService.findCarrerasByCantidadCuatrimestresAfter(12);
        carrerasPorAnio.forEach(System.out::println);*/
    }
}

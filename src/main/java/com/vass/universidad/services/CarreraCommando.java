package com.vass.universidad.services;

import com.vass.universidad.entities.Carrera;
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
    }
}

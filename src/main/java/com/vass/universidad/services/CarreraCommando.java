package com.vass.universidad.services;

import com.vass.universidad.entities.Carrera;
import com.vass.universidad.services.contract.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CarreraCommando implements CommandLineRunner {

    @Autowired
    private CarreraService carreraService;

    @Override
    public void run(String... args) throws Exception {
        /*Carrera inSistemas = new Carrera(null, "Ingenieria en Sistemas", 12, 8);
        Carrera cSave = carreraService.save(inSistemas);
        System.out.println(cSave.toString());*/
    }
}

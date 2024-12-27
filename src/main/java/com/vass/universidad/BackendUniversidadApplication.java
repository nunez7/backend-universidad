package com.vass.universidad;

import com.vass.universidad.entities.Alumno;
import com.vass.universidad.entities.Direccion;
import com.vass.universidad.entities.Persona;
import com.vass.universidad.services.contract.AlumnoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendUniversidadApplication {

	@Autowired
	private AlumnoService service;

	private static final Logger logger = LoggerFactory.getLogger(BackendUniversidadApplication.class);
	public static void main(String[] args) {
		String[] beanDefinitionsNames =	SpringApplication.run(BackendUniversidadApplication.class, args).getBeanDefinitionNames();
		/*for (String str : beanDefinitionsNames){
			logger.info(str);
		}*/
	}

	@Bean
	public CommandLineRunner runner(){
		return args -> {
			Direccion direc = new Direccion("Juarez", "34", "63000", "Santiago Ixcuintla");
			Persona alumno = new Alumno(null, "Raul", "Perez", direc, "55-323");
			Persona alumnoSave = service.save(alumno);
			logger.info("ALUMNO NUEVO: {}", alumnoSave);
		};
	}

}

package com.vass.universidad;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendUniversidadApplication {

	private static final Logger logger = LoggerFactory.getLogger(BackendUniversidadApplication.class);
	public static void main(String[] args) {
		String[] beanDefinitionsNames =	SpringApplication.run(BackendUniversidadApplication.class, args).getBeanDefinitionNames();
		/*for (String str : beanDefinitionsNames){
			logger.info(str);
		}*/
	}

}

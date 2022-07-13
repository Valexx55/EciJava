package edu.eci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MseurekaprofeApplication {
	
	/**
	 * PASOS PARA CREAR EUREKA
	 * 
	 * 1) Spring starter-project , Add dependencia de Eureka Server
	 * 2) Añadimos la dependecia de galssfish (jaxb)
	 * 3) Anotamos el main con @EnableEurekaServer
	 * 4) Configurar las propiedades
	 * 
	 */

	public static void main(String[] args) {
		SpringApplication.run(MseurekaprofeApplication.class, args);
	}

}

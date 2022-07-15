package edu.eci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsgatewayprofeApplication {
	
	/**
	 * CONFIGURACION GATEWAY
	 * 
	 * 1) CREO PROYECTO CON DEPEDENCIAS GATEWAY Y EUREKACLIENT
	 * 2) ADD ANOTACIÓN @EnableEurekaClient en el MAIN
	 * 3) CONFIGURAR PROPERTIES / YAML
	 * 
	 */

	public static void main(String[] args) {
		SpringApplication.run(MsgatewayprofeApplication.class, args);
	}

}

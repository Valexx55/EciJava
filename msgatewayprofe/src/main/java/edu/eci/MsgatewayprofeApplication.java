package edu.eci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsgatewayprofeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsgatewayprofeApplication.class, args);
	}

}

package edu.eci.controller;
import org.springframework.boot.web.server.LocalServerPort;

import edu.eci.MsalumnosprofeApplication;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment =  WebEnvironment.RANDOM_PORT)
public class AlumnoControllerTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	TestRestTemplate template;

	@Test //una prueba tonta: comprobamos que leyendo alumnos recupera un texto que tiene un apellido
	public void testGetAlumno () {
		assertThat(this.template.getForObject("http://localhost:"+ port+"/alumno", String.class)).contains("apellido");
	}
	
	@BeforeEach
	public void antesDeCadaTest ()
	{
		System.out.println("antes de cada test");
	}
	
	@BeforeAll
	public static void antesDeTodosLosTests ()
	{
		System.out.println("antes de cada test");
	}
	
	@AfterEach
	public void despuesDeCadaTest ()
	{
		System.out.println("despues de cada test");
	}
	
	@AfterAll
	public static void despuesDeTodosLosTests ()
	{
		System.out.println("despues de cada test");
	}
	
	


}

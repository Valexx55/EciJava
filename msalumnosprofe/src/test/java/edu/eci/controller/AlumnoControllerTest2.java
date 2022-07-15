package edu.eci.controller;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import edu.eci.MsalumnosprofeApplication;
import edu.eci.repository.entity.Alumno;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import util.UtilTest;


//puedo indicar qué clase quiero testar, si no busca directamente la que tiene @SpringBootApplication (la main)
@SpringBootTest(classes = MsalumnosprofeApplication.class)
@AutoConfigureMockMvc // mockeo el servidor
public class AlumnoControllerTest2  
{

	@Autowired
	private MockMvc mockMvc; // el objeto con el que lanzamos las peticiones HTTP

	@Test
	public void insertarAlumnoTest() throws Exception {
		Alumno alumno = new Alumno();
		alumno.setNombre("Juan");
		alumno.setApellido("Moreno");
		alumno.setEdad(22);
		alumno.setEmail("juanmo@mail.es");

		// serializar este alumno
		String json_alumno = UtilTest.toJSON(alumno);

		mockMvc.perform(post("/alumno").contentType(MediaType.APPLICATION_JSON).content(json_alumno))
				.andExpect(status().isCreated()).andExpect(content().contentType("application/json"));

	}
	
	//TODO: INSERTAR ALUMNO CON FALLOS DE VALIDACIÓN/REPETIDO, etc.
}

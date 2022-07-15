package edu.eci.controller;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import edu.eci.repository.entity.Alumno;
import edu.eci.service.AlumnoService;
import util.UtilTest;

@WebMvcTest(AlumnoController.class)//levantar el contexto parcialmente de las clases indicadas
public class AlumnoControllerTest3 {

	@Autowired
	private MockMvc mockMvc; // el objeto con el que lanzamos las peticiones HTTP
	
	@MockBean
	AlumnoService alumnoService; //es un servicio de mentirijilla--> todo: programar su comportamiento

	@Test
	public void getServicioMockeado() throws Exception {
		
		Alumno alumno = new Alumno();
		alumno.setId(1l);
		alumno.setNombre("Juan");
		alumno.setApellido("Moreno");
		alumno.setEdad(22);
		alumno.setEmail("juanmo@mail.es");

		// serializar este alumno
		String json_alumno = UtilTest.toJSON(alumno);
		
		//programamos el funcionamiento del mock
		when(alumnoService.leerPorId(1l)).thenReturn(Optional.of(alumno));

		this.mockMvc.perform(get("/alumno/1")).
		andDo(print()).
		andExpect(status().isOk()).
		andExpect(content().contentType("application/json")).
		andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value("Juan")).
		andExpect(MockMvcResultMatchers.jsonPath("$.edad").value("22"));
	}
	
	//TODO: INSERTAR ALUMNO CON FALLOS DE VALIDACIÓN/REPETIDO, etc.
}

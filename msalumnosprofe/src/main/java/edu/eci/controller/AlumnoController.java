package edu.eci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.repository.entity.Alumno;
import edu.eci.service.AlumnoService;

@RestController//contoller (servlets) + JSON
@RequestMapping("/alumno")//todas las peticiones que vengan con esta ruta, van a esta clase
public class AlumnoController {
	
	//MÉTODOS HTTP
	//REST FULL - CLAB CRUD -ABMC ALUMNOS
	//ENVIAMOS Y RX JSONES POR DEFECTO
	//CREAR - POST
	//LEER - GET
	//ACTUALIZAR - PUT
	//BORRAR - DELETE
	
	@Autowired//Inject en estándar
	private AlumnoService alumnoService;
	
	@GetMapping("/obtener-alumno-test")
	public Alumno obtenerAlumnoTest ()
	{
		Alumno alumno = null;
		
			alumno = new Alumno();
			alumno.setNombre("Olga");
			alumno.setEdad(15);
			alumno.setEmail("olga@mail.es");
			alumno.setApellido("Lopez");
			
		return alumno;
	}

	@GetMapping // http://localhost:8081/alumno GET
	public ResponseEntity<?> listarAlumnos ()
	{
		ResponseEntity<?> responseEntity = null; //esto representa el mensaje http de vuelta
		Iterable<Alumno> iterable_alumnos = null;
		
				iterable_alumnos = this.alumnoService.recuperarTodos();
				responseEntity = ResponseEntity.ok(iterable_alumnos);//esto genera un HTTP con Status 200 y en el body, la lista 
				
		return responseEntity;
	}

}

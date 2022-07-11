package edu.eci.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.repository.entity.Alumno;
import edu.eci.service.AlumnoService;

@RestController // contoller (servlets) + JSON
@RequestMapping("/alumno") // todas las peticiones que vengan con esta ruta, van a esta clase
public class AlumnoController {

	// MÉTODOS HTTP
	// REST FULL - CLAB CRUD -ABMC ALUMNOS
	// ENVIAMOS Y RX JSONES POR DEFECTO
	// CREAR - POST
	// LEER - GET
	// ACTUALIZAR - PUT
	// BORRAR - DELETE

	@Autowired // Inject en estándar
	private AlumnoService alumnoService;
	
	Logger log = LoggerFactory.getLogger(AlumnoController.class);

	@GetMapping("/obtener-alumno-test")
	public Alumno obtenerAlumnoTest() {
		Alumno alumno = null;

		alumno = new Alumno();
		alumno.setNombre("Olga");
		alumno.setEdad(15);
		alumno.setEmail("olga@mail.es");
		alumno.setApellido("Lopez");

		return alumno;
	}

	@GetMapping // http://localhost:8081/alumno GET
	public ResponseEntity<?> listarAlumnos() {
		ResponseEntity<?> responseEntity = null; // esto representa el mensaje http de vuelta
		Iterable<Alumno> iterable_alumnos = null;

		iterable_alumnos = this.alumnoService.recuperarTodos();
		responseEntity = ResponseEntity.ok(iterable_alumnos);// esto genera un HTTP con Status 200 y en el body, la
																// lista

		return responseEntity;
	}

	@GetMapping("/{id}") // http://localhost:8081/alumno/1 GET
	public ResponseEntity<?> listarAlumnoPorID(@PathVariable Long id) {
		ResponseEntity<?> responseEntity = null; // esto representa el mensaje http de vuelta
		Optional<Alumno> optional_alumno = null;

		optional_alumno = this.alumnoService.leerPorId(id);
		if (optional_alumno.isPresent()) {
			// devolver un 200 con el alumno en el cuerpo
			Alumno alumno = optional_alumno.get();// extraigo el alumno del optional
			responseEntity = ResponseEntity.ok(alumno);
		} else {
			// no content
			responseEntity = ResponseEntity.noContent().build();// si el mensaje no tiene cuerpo, usamos build para
																// conformarlo
		}

		return responseEntity;
	}
	
	private ResponseEntity<?> obtenerErrores (BindingResult bindingResult)
	{
		ResponseEntity<?> responseEntity = null;
		List<ObjectError> lista_errores = null;
		
			lista_errores = bindingResult.getAllErrors();
			responseEntity = ResponseEntity.badRequest().body(lista_errores);
			
			//TODO log de errores 
			lista_errores.forEach(objeto_error -> log.error(objeto_error.toString()));
		
		return responseEntity;
	}

	@PostMapping // http://localhost:8081/alumno POST // binding result almacena el resultado de la validación
	public ResponseEntity<?> insertarAlumno(@Valid @RequestBody Alumno alumno, BindingResult bindingResult) {
		ResponseEntity<?> responseEntity = null; // esto representa el mensaje http de vuelta
		Alumno alumno_insertado = null;

		log.debug("entrando en insertarAlumno" );
		if (bindingResult.hasErrors()) {
			//genero un mensaje con los errores
			log.debug("alumno con errores" );
			responseEntity = obtenerErrores(bindingResult);

		} else {
			log.debug("alumno sin errores" );
			alumno_insertado = this.alumnoService.guardar(alumno);
			responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(alumno_insertado);
		}
		return responseEntity;
	}

	@DeleteMapping("/{id}") // http://localhost:8081/alumno/1 DELETE
	public ResponseEntity<?> borrarAlumnoPorId(@PathVariable Long id) {
		ResponseEntity<?> responseEntity = null; // esto representa el mensaje http de vuelta

		this.alumnoService.borrarPorId(id);
		responseEntity = ResponseEntity.ok().build();

		return responseEntity;
	}

	@PutMapping("/{id}") // http://localhost:8081/alumno/id PUT
	public ResponseEntity<?> modificarAlumno(@Valid @RequestBody Alumno alumno, BindingResult bindingResult ,@PathVariable Long id) {
		ResponseEntity<?> responseEntity = null; // esto representa el mensaje http de vuelta
		Alumno alumno_modificado = null;
			
			log.debug("entrando en modificarAlumno" );
			if (bindingResult.hasErrors())
			{
				log.debug("alumno con errores" );
				responseEntity = obtenerErrores(bindingResult);
			}
			else {
				log.debug("alumno sin errores" );
				alumno_modificado = this.alumnoService.actualizar(alumno, id);
				
				if (alumno_modificado != null) {
					responseEntity = ResponseEntity.ok(alumno_modificado);
				} else {
					responseEntity = ResponseEntity.notFound().build();
				}
				
			}
		

		return responseEntity;
	}
	
	@GetMapping("/buscarPorNombreLike/{patron}") // http://localhost:8081/alumno/buscarPorNombreLike/p GET
	public ResponseEntity<?> listarAlumnosPorNombreLike(@PathVariable String patron) {
		ResponseEntity<?> responseEntity = null; // esto representa el mensaje http de vuelta
		Iterable<Alumno> iterable_alumnos = null;

		log.debug("entrando en buscarPorNombreLike " + patron );
		iterable_alumnos = this.alumnoService.findByNombreLike(patron);
		responseEntity = ResponseEntity.ok(iterable_alumnos);// esto genera un HTTP con Status 200 y en el body, la
		log.debug("saliendo de buscarPorNombreLike " + iterable_alumnos);											// lista

		return responseEntity;
	}
	
	@GetMapping("/buscarPorRangoEdad/{min}/{max}") //http://localhost:8080/alumno/buscarPorRangoEdad/{min,max} se hace un GET
	public ResponseEntity<?> listarAlumnosPorRangoEdad(@PathVariable int min, @PathVariable int max ) {
		ResponseEntity<?> responseEntity = null;
		Iterable<Alumno> iterable_alumnos = null;
		
		log.debug("entrando en buscarPorRangoEdad entre " + min + " y " + max);
		iterable_alumnos = this.alumnoService.findByEdadBetween(min, max);
		
		responseEntity = ResponseEntity.ok(iterable_alumnos); //esto genera un HTTP con status 200 y con el body iterable_alumnos
		log.debug("saliendo de buscarPorRangoEdad " + iterable_alumnos);
		
			
		return responseEntity;
	}
	
	@GetMapping("/buscarPorNombreOApellidoLike/{patron}") // http://localhost:8081/alumno/buscarPorNombreLike/p GET
	public ResponseEntity<?> buscarPorNombreOApellidoLike(@PathVariable String patron) {
		ResponseEntity<?> responseEntity = null; // esto representa el mensaje http de vuelta
		Iterable<Alumno> iterable_alumnos = null;

		log.debug("entrando en buscarPorNombreOApellidoLike " + patron );
		iterable_alumnos = this.alumnoService.busquedaPorNombreOApellidoNativa(patron);
		responseEntity = ResponseEntity.ok(iterable_alumnos);// esto genera un HTTP con Status 200 y en el body, la
		log.debug("saliendo de buscarPorNombreOApellidoLike " + iterable_alumnos);											// lista

		return responseEntity;
	}
	
	@GetMapping("/obtenerAlumnosAltaHoy") // http://localhost:8081/alumno/obtenerAlumnosAltaHoy GET
	public ResponseEntity<?> listarAlumnosRegistradosHoy() {
		ResponseEntity<?> responseEntity = null; // esto representa el mensaje http de vuelta
		Iterable<Alumno> iterable_alumnos = null;

		iterable_alumnos = this.alumnoService.procediminetoAlumnosAltaHoy();
		responseEntity = ResponseEntity.ok(iterable_alumnos);// esto genera un HTTP con Status 200 y en el body, la
																// lista

		return responseEntity;
	}

	

}

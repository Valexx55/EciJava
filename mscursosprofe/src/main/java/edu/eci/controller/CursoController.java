package edu.eci.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.repository.entity.Alumno;
import edu.eci.repository.entity.Curso;
import edu.eci.service.CursoService;



@RestController
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	Logger log = LoggerFactory.getLogger(CursoController.class);
	
	@GetMapping
	public ResponseEntity<?> listarCursos ()
	{
		ResponseEntity<?> responseEntity = null;
		Iterable<Curso> lista_cursos = null;
			
			lista_cursos = this.cursoService.findAll();
			responseEntity = ResponseEntity.ok(lista_cursos);
		
		
		return responseEntity;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listarCursoPorId (@PathVariable Long id)
	{
		ResponseEntity<?> responseEntity = null;
		Optional<Curso> op_curso = null;
		
			op_curso = this.cursoService.findById(id);
			if (op_curso.isPresent())
			{
				Curso curso_leido = op_curso.get();
				responseEntity = ResponseEntity.ok(curso_leido);
			}
			else {
				responseEntity = ResponseEntity.noContent().build();
			}
		
		return responseEntity;
	}
	
	@PostMapping
	public ResponseEntity<?> crearCurso (@RequestBody Curso curso)
	{
		ResponseEntity<?> responseEntity = null;
		Curso curso_creado = null;
		
			curso_creado = this.cursoService.save(curso);
			responseEntity = ResponseEntity.ok(curso_creado);
		
		return responseEntity;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> modificarCurso (@RequestBody Curso curso, @PathVariable Long id)
	{
		ResponseEntity<?> responseEntity = null;
		Curso curso_modificado = null;
		
			curso_modificado = this.cursoService.update(curso, id);
			if (curso_modificado!=null)
			{
				
				responseEntity = ResponseEntity.ok(curso_modificado);
			}
			else {
				responseEntity = ResponseEntity.notFound().build();
			}
	
		
		return responseEntity;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrarCursoPorId (@PathVariable Long id)
	{
		ResponseEntity<?> responseEntity = null;
		
			this.cursoService.deleteById(id);
			responseEntity = ResponseEntity.ok().build();
		
		return responseEntity;
	}
	
	@PutMapping("/asignar-alumnos/{id}") 
	public ResponseEntity<?> asginarAlumnos(@RequestBody List<Alumno> alumnos, @PathVariable Long id) {
		ResponseEntity<?> responseEntity = null;
		Curso curso_modificado = null;
		Optional<Curso> opc = null;

			log.debug("asginarAlumnos");
			opc = this.cursoService.asginarAlumnos(alumnos, id);
			
			if (opc.isPresent())
			{
				curso_modificado = opc.get();
				responseEntity = ResponseEntity.ok(curso_modificado);
				log.debug("Curso Actualizado!!! :)");
			} else {
				responseEntity = ResponseEntity.notFound().build();
				log.debug("Curso NO Actualizado!!! :(");
			}
			log.debug("saliendo de asginarAlumnos");

		return responseEntity;
	}
	
	
	@PutMapping("/eliminar-alumno/{id}") 
	public ResponseEntity<?> eliminarAlumno(@RequestBody Alumno alumno, @PathVariable Long id) {
		ResponseEntity<?> responseEntity = null;
		Curso curso_modificado = null;
		Optional<Curso> opc = null;

			log.debug("eliminarAlumno");
			opc = this.cursoService.eliminarAlumnos(alumno, id);
			
			if (opc.isPresent())
			{
				curso_modificado = opc.get();
				responseEntity = ResponseEntity.ok(curso_modificado);
				log.debug("Curso Actualizado!!! :)");
			} else {
				responseEntity = ResponseEntity.notFound().build();
				log.debug("Curso NO Actualizado!!! :(");
			}
			log.debug("saliendo de eliminarAlumno");

		return responseEntity;
	}
	
	
	@GetMapping("/obtenercursonativa/{idalumno}") 
	public ResponseEntity<?> obtenerCursoAlumnoNativa(@PathVariable Long idalumno) {
		ResponseEntity<?> responseEntity = null;
		Optional<Curso> op_curso = null;
		Curso curso_leido = null;

			log.debug("obtenerCursoAlumnoNativa ()");
	
			op_curso = this.cursoService.obtenerCursoAlumnoNativa(idalumno);
			
			if (op_curso.isPresent())
			{
				curso_leido = op_curso.get();
				responseEntity = ResponseEntity.ok(curso_leido);
			} else {
				responseEntity = ResponseEntity.noContent().build();
			}

		return responseEntity;
	}
	
	
	@GetMapping("/obtenercursojpql/{idalumno}") 
	public ResponseEntity<?> obtenerCursoAlumnoJPQL(@PathVariable Long idalumno) {
		ResponseEntity<?> responseEntity = null;
		Optional<Curso> op_curso = null;
		Curso curso_leido = null;

			log.debug("obtenerCursoAlumnoJPQL ()");
	
			op_curso = this.cursoService.obtenerCursoAlumnoJPQL(idalumno);
			
			if (op_curso.isPresent())
			{
				curso_leido = op_curso.get();
				responseEntity = ResponseEntity.ok(curso_leido);
			} else {
				responseEntity = ResponseEntity.noContent().build();
			}

		return responseEntity;
	}
}
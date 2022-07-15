package edu.eci.controller;

import java.util.Optional;

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

import edu.eci.repository.entity.Curso;
import edu.eci.service.CursoService;



@RestController
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
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
}
package edu.eci.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.eci.repository.entity.Curso;

public interface CursoRepository extends CrudRepository<Curso, Long>{
	
	//DADO UN ALUMNO (ID)
		//A QUÉ CURSO ESTÁ ASGINADO?¿
		
		//NATIVA
		@Query( value = "select * from cursos where id = "
		+ "(select curso_id from cursos_alumnos where alumnos_id = ?1)"
		,nativeQuery = true)
		public Optional<Curso> obtenerCursoAlumnoNativa (Long id_alumno);
		
		//JPLQ
		@Query("select c from Curso c JOIN c.alumnos l where l.id= ?1")
		public Optional<Curso> obtenerCursoAlumnoJPQL (Long id_alumno);

}

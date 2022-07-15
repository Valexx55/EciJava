package edu.eci.service;

import java.util.List;
import java.util.Optional;

import edu.eci.repository.entity.Alumno;
import edu.eci.repository.entity.Curso;

public interface CursoService {

	public Iterable<Curso> findAll();

	public Optional<Curso> findById(Long id);

	public Curso save(Curso curso);

	public void deleteById(Long id);

	public Curso update(Curso curso, Long id);

	public Optional<Curso> asginarAlumnos(List<Alumno> alumnos, Long id);

	public Optional<Curso> eliminarAlumnos(Alumno alumno, Long id);

	public Optional<Curso> obtenerCursoAlumnoNativa(Long id_alumno);

	public Optional<Curso> obtenerCursoAlumnoJPQL(Long id_alumno);

}

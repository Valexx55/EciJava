package edu.eci.service;

import java.util.Optional;

import edu.eci.repository.entity.Curso;

public interface CursoService {

	public Iterable<Curso> findAll();

	public Optional<Curso> findById(Long id);

	public Curso save(Curso curso);

	public void deleteById(Long id);

	public Curso update(Curso curso, Long id);

}

package edu.eci.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.eci.repository.CursoRepository;
import edu.eci.repository.entity.Alumno;
import edu.eci.repository.entity.Curso;

@Service
public class CuroServiceImpl implements CursoService{
	
	@Autowired
	private CursoRepository cursoRepository;
	
	

	@Override
	@Transactional (readOnly = true)
	public Iterable<Curso> findAll() {
		return this.cursoRepository.findAll();
	}

	@Override
	@Transactional (readOnly = true)
	public Optional<Curso> findById(Long id) {
		return this.cursoRepository.findById(id);
	}

	@Override
	@Transactional
	public Curso save(Curso curso) {
		
		return this.cursoRepository.save(curso);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.cursoRepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public Curso update(Curso curso, Long id) {
		Curso curso_actualizdo = null;
		
			Optional<Curso> opc = this.cursoRepository.findById(id);
			if (opc.isPresent())
			{
				Curso curso_leido = opc.get();
				curso_leido.setNombre(curso.getNombre());
				
				curso_actualizdo = this.cursoRepository.save(curso_leido);
			}
		
		return curso_actualizdo;
	}
	
	@Override
	@Transactional
	public Optional<Curso> asginarAlumnos(List<Alumno> alumnos, Long id) {
		Optional<Curso> opc = Optional.empty();
		Curso curso_leido;
		Curso curso_actualizado = null;
		
				opc = this.cursoRepository.findById(id);
				if (opc.isPresent())
				{
					//asignar los alumnos
					curso_leido = opc.get();
					alumnos.forEach(a -> curso_leido.addAlumno(a));
					
					curso_actualizado = this.cursoRepository.save(curso_leido);
					opc = Optional.of(curso_actualizado);
					
				}
		return opc;
	}

	@Override
	@Transactional
	public Optional<Curso> eliminarAlumnos(Alumno alumno, Long id) {
		Optional<Curso> opc = Optional.empty();
		Curso curso_leido;
		Curso curso_actualizado = null;
		
				opc = this.cursoRepository.findById(id);
				if (opc.isPresent())
				{
					//asignar los alumnos
					curso_leido = opc.get();
					curso_leido.removeAlumno(alumno);
					
					curso_actualizado = this.cursoRepository.save(curso_leido);
					opc = Optional.of(curso_actualizado);
					
				}
		return opc;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Curso> obtenerCursoAlumnoNativa(Long id_alumno) {
		return this.cursoRepository.obtenerCursoAlumnoNativa(id_alumno);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Curso> obtenerCursoAlumnoJPQL(Long id_alumno) {
		return this.cursoRepository.obtenerCursoAlumnoJPQL(id_alumno);
	}

	

}

package edu.eci.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.eci.repository.AlumnoRepository;
import edu.eci.repository.entity.Alumno;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	@Autowired
	private AlumnoRepository alumnoRepository;

	@Override
	@Transactional (readOnly = true)
	public Iterable<Alumno> recuperarTodos() {
		return this.alumnoRepository.findAll();
	}

	@Override
	@Transactional (readOnly = true)
	public Optional<Alumno> leerPorId(Long id) {
		return this.alumnoRepository.findById(id);
	}

	@Override
	@Transactional
	public Alumno guardar(Alumno alumno) {
		return this.alumnoRepository.save(alumno);
	}

	@Override
	@Transactional
	public void borrarPorId(Long id) {
		this.alumnoRepository.deleteById(id);
	}

	@Override
	@Transactional
	public Alumno actualizar(Alumno alumno, Long id) {
		Alumno alumnno_modificado = null;
		Optional<Alumno> oa = null;
		
				oa = this.alumnoRepository.findById(id);
				if (oa.isPresent())
				{
					Alumno alumno_leido = oa.get();
					alumno_leido.setApellido(alumno.getApellido());
					alumno_leido.setNombre(alumno.getNombre());
					alumno_leido.setEmail(alumno.getEmail());
					alumno_leido.setEdad(alumno.getEdad());
					
					alumnno_modificado = alumno_leido;
					 
				}
		
		return alumnno_modificado;
	}

}

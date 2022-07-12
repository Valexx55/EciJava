package edu.eci.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> findByNombreLike(String patron) {
		
		return this.alumnoRepository.findByNombreLike("%"+patron+"%");
	}
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> findByEdadBetween(int edad_min, int edad_max) {
		
		return this.alumnoRepository.findByEdadBetween(edad_min, edad_max);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Alumno> findByEdadBetween(int edad_min, int edad_max, Pageable pageable) {
		
		return this.alumnoRepository.findByEdadBetween(edad_min, edad_max, pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Alumno> busquedaPorNombreOApellidoNativaPag(String patron, Pageable pageable) {
		
		return this.alumnoRepository.busquedaPorNombreOApellidoNativaPag(patron, pageable);
	}

	@Override
	@Transactional //AUNQUE EL PROC NO SEA UNA OPERACIÓN DE ESCRITURA, HAY QUE PONERLO COMO SI LO FUERA READONLY A FALSE
	public Iterable<Alumno> procediminetoAlumnosAltaHoy() {
		
		
		return this.alumnoRepository.procediminetoAlumnosAltaHoy();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Alumno> leerAlumnosPorPagina(Pageable p) {
		return this.alumnoRepository.findAll(p);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Alumno> busquedaPorNombreOApellidoPaginado(String patron, Pageable pageable) {
		
		return this.alumnoRepository.busquedaPorNombreOApellidoPaginado(patron, pageable);
	}

}

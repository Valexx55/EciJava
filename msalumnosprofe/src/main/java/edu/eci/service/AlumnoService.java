package edu.eci.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.eci.repository.entity.Alumno;

public interface AlumnoService {
	
	//recuperarTodos
	public Iterable<Alumno> recuperarTodos();
	
	//leerPorId
	
	public Optional<Alumno> leerPorId (Long id);
	
	//guardar
	
	public Alumno guardar (Alumno alumno);
	
	//borrarPorId
	
	public void borrarPorId (Long id);
	
	//actualizar
	
	public Alumno actualizar (Alumno alumno, Long id);
	
	//buscar por Nombre Like
	
	public Iterable<Alumno> findByNombreLike (String patron);


	//buscar por edad en rango
	
	public Iterable<Alumno> findByEdadBetween(int edad_min, int edad_max);
	
	public Page<Alumno> findByEdadBetween (int edad_min, int edad_max, Pageable p);
	
	//buscamos por nombre o apellido nativa
	
	//public Iterable<Alumno> busquedaPorNombreOApellidoNativa (String patron);
	public Page<Alumno> busquedaPorNombreOApellidoNativaPag (String patron, Pageable pageable);
	
	//LISTAMOS los alumnos dados de alta hoy
	
	public Iterable<Alumno> procediminetoAlumnosAltaHoy ();
	
	//LISTAR alumnos por páginas/bloques de la BD
	public Page<Alumno> leerAlumnosPorPagina (Pageable p);
	
	//LISTAR alumnos por páginas/bloques de la BD con consulta
	public Page<Alumno> busquedaPorNombreOApellidoPaginado (String patron, Pageable pageable);
}

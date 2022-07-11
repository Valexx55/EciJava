package edu.eci.service;

import java.util.Optional;

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
	
	//buscamos por nombre o apellido nativa
	
	public Iterable<Alumno> busquedaPorNombreOApellidoNativa (String patron);
	
	//LISTAMOS los alumnos dados de alta hoy
	
	public Iterable<Alumno> procediminetoAlumnosAltaHoy ();
}

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

}

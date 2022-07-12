package edu.eci.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import edu.eci.repository.entity.Alumno;

//PUEDO PAGINAR TODAS LAS CONSULTAS AÑADIENDO EL PARÁMETRO PAGEABLE AL FINAL
//CON INDEPENDENCIA DE LA TECNLOGÍA USADA (KEYWORD, JPQL, NATIVA, ETC)

//@Repository no hace falta ponerlo
//simplemente heredando de este tipo, ya está implementada la operativa CRUD
//public interface AlumnoRepository extends CrudRepository<Alumno, Long>{
//haciendo que herede de Paging, consigo añadir acceso paginado a la BD
public interface AlumnoRepository extends PagingAndSortingRepository<Alumno, Long>{

	
	//1 KEYWORD QUERIES CONSULTA POR PALABRAS CLAVE
	
		//Obtener listado de alumnos en un rago de edad
		public Iterable<Alumno> findByEdadBetween (int edad_min, int edad_max);
		//Obtenee listado de alumnos cuyo nombre cumpla un patrón
		public Iterable<Alumno> findByNombreLike (String patron);
		
		//PRUEBA MIX KEYWORD + PAGINACION
		public Page<Alumno> findByEdadBetween (int edad_min, int edad_max, Pageable p);
		
	//2 NATIVAS
		
		//Obtener listado de alumnos por nombre o apellido like
		//@Query(value = "select * from alumnos a where a.nombre like %?1% or a.apellido like %?1%", nativeQuery = true)
		//public Iterable<Alumno> busquedaPorNombreOApellidoNativa (String patron);
		
		@Query(value = "select * from alumnos a where a.nombre like %?1% or a.apellido like %?1%", nativeQuery = true)
		public Page<Alumno> busquedaPorNombreOApellidoNativaPag (String patron, Pageable pageable);
		
	//3 PROCEDIMINETOS ALMACENADOS
		
		//1 CREO EL PROCEDIMIENTO EN LA BASE DATOS
		//2 LO REERENCIO DESDE LA ENTIDAD
		//3 DEFINO LA LLAMADA EN EL REPOSITORY
		
		@Procedure(name = "Alumno.alumnosRegistradosHoy")
		public Iterable<Alumno> procediminetoAlumnosAltaHoy ();
		
	//4 CONSULTA PAGINADA con JPQL
		@Query("select a from Alumno a where a.nombre like %?1% or a.apellido like %?1%")
		public Page<Alumno> busquedaPorNombreOApellidoPaginado (String patron, Pageable pageable);
}

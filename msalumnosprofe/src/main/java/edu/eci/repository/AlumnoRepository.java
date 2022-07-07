package edu.eci.repository;

import org.springframework.data.repository.CrudRepository;

import edu.eci.repository.entity.Alumno;

//@Repository no hace falta ponerlo
//simplemente heredando de este tipo, ya está implementada la operativa CRUD
public interface AlumnoRepository extends CrudRepository<Alumno, Long>{

}

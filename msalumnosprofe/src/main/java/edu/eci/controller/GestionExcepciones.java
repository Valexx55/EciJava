package edu.eci.controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
 * VAMOS A HACER QUE ESTA CLASE
 * SEA EL SUMIDERO DE LOS ERRORES
 * "LISTENER"
 * 
 * Con esta anotación, condfiguramos
 * que todos las excepciones de estos paquetes
 * se escuchan aquí
 */
@RestControllerAdvice (basePackages = {"edu.eci"})
public class GestionExcepciones {
	
	@ExceptionHandler(Throwable.class)//inico qué tipo de expcecion se gestiona en este método
	public ResponseEntity<?> excepcionEnServicio (Throwable e)
	{
		ResponseEntity<?> responseEntity = null;
		String str_exception = null;
		
			str_exception = "ERROR en PETICION " + e.toString();
			responseEntity = ResponseEntity.internalServerError().body(str_exception);
		
		return responseEntity;
	}
	
	@ExceptionHandler(org.springframework.dao.EmptyResultDataAccessException.class)
	public ResponseEntity<?> errorBorradoIDNoExiste (EmptyResultDataAccessException e)
	{
		ResponseEntity<?> responseEntity = null;
		String str_exception = null;
		
			str_exception = "ERROR AL BORRAR ID QUE NO EXISTE " + e.toString();
			responseEntity = ResponseEntity.internalServerError().body(str_exception);
		
		return responseEntity;
	}

}

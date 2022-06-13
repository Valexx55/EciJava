package ejercicio1.exception;

/**
 * EXISTEN DOS CATEGORÍAS BÁSICAS DE EXCEPCIONES
 * 
 * LAS CHECKED Y LAS UNCHECKED
 * 
 * LAS PRIMERAS JAVA ME OLBIGA A PROCESARLAS (CAPTURARLAS O PROPAGARLAS)
 * 
 * LAS SEGUNDAS, HEREDAN DE RUNTIMEEXCEPTION  Y ESTOY EXENTO DE PROCESARLAS
 * 
 * @author USUARIO
 *
 */
public class NotaException extends RuntimeException {
	
	public static final String MENSAJE = """
			NOTA 
			FUERA 
			DEL RANGO 
			PERMITIDO. 
			Introduzca una nota de 0 a 10
			"""; //STRING MULTILINEA J15

	public NotaException()
	{
		super(MENSAJE);
	}
}

package ejercicio1.ficheros;

import java.util.ArrayList;
import java.util.List;

import ejercicio1.bean.Alumno;
import ejercicio1.bean.Persona;
import ejercicio1.exception.NotaException;
import ejercicio1.util.UtilColecciones;

public class MainFicheros {
	
	public static void main(String[] args) {
		
		List<Alumno> la = UtilColecciones.obtenerListaALumnos(15);
		
		UtilFicheros.escribirListaAlumnos(la, "listaalumnos.txt");
	}

}

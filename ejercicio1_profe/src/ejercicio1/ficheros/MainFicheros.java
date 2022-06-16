package ejercicio1.ficheros;

import java.util.List;

import ejercicio1.bean.Alumno;
import ejercicio1.util.UtilColecciones;

public class MainFicheros {
	
	public static void main(String[] args) {
		
		List<Alumno> la = UtilColecciones.obtenerListaALumnos(15);
		
		UtilFicheros.escribirListaAlumnos(la, "listaalumnos.txt");
		la = UtilFicheros.cargarAlumnos("listapropiedades.txt");
		
		System.out.println("lista cargada = " + la);
		
		UtilFicherosStream.escribirListaAlumnos(la, "listaalumnos.txt");
		la = UtilFicherosStream.cargarAlumnos("listapropiedades.txt");
		
		System.out.println("lista cargada = " + la);
		
	}
	
	

}

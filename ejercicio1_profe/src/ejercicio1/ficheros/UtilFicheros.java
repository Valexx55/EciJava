package ejercicio1.ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import ejercicio1.bean.Alumno;

public class UtilFicheros {
	

	public static void escribirListaAlumnos(List<Alumno> la, String nf) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(nf)))) {
			for (Alumno a : la) {
				bw.write(a.toString());
				bw.newLine();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	// TODO
	// haced un método que reciba el nombre de un fichero
	// y devuelva la lista de alumnos con la info extraída
	//el fichero tiene el siguiente formato
	// (linea1) nombre1, nombre2, nombre3, etc.
	// (linea2) edad1, edad2, edad3, etc.
	// (linea1) nota1, nota2, nota3, etc.
	
	public static List<Alumno> cargarAlumnos (String nombre_fichero)
	{
		List<Alumno> lista_alumnos = null;
		
			//TODO haced el cuerpo de este método!!!
		
		return lista_alumnos;
	}

	public static void main(String[] args) {
		String cadprueba = "hola,no,se,si,hoy,es,viernes,o,lunes";
		String[] cadenas = cadprueba.split(",");
		for (String cadena : cadenas) {
			System.out.println(cadena);
		}
	}
}

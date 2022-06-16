package ejercicio1.ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
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
			e.printStackTrace();
		}

	}


	public static List<Alumno> cargarAlumnos(String nombre_fichero) {
		List<Alumno> lista_alumnos = null;
		String lineaNombres = null;
		String  lineaEdad = null; 
		String lineaNota = null;

		try (BufferedReader br = new BufferedReader(new FileReader(nombre_fichero))) {
			lineaNombres = br.readLine();
			lineaEdad = br.readLine();
			lineaNota = br.readLine();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String [] nombres = lineaNombres.split(",");
		String [] edades = lineaEdad.split(",");
		String [] notas = lineaNota.split(",");
		
		Alumno alumno = null;
		lista_alumnos = new ArrayList<>();
		for (int pos = 0; pos<nombres.length; pos++) {
			alumno = new Alumno (nombres[pos], Integer.parseInt(edades[pos]), Integer.parseInt(notas[pos]));
			lista_alumnos.add(alumno);
		}
		
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

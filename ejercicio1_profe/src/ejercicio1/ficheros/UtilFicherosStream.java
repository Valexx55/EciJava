package ejercicio1.ficheros;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import ejercicio1.bean.Alumno;

public class UtilFicherosStream {

	public static void escribirListaAlumnos(List<Alumno> la, String nf) {
		
		
		try {
			Path p = Path.of(nf);
			Files.write(p, la.stream().map(a->a.toString()).toList(), Charset.forName("UTF-8"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public static List<Alumno> cargarAlumnos(String nombre_fichero) {
		List<Alumno> lista_alumnos = null;
		try {
			Path p = Path.of(nombre_fichero);
			List<String> lineas = Files.readAllLines(p);//cada elemento de la lista es una linea
			
			String [] nombres = lineas.get(0).split(",");
			String [] edades = lineas.get(1).split(",");
			String [] notas = lineas.get(2).split(",");
			
			Alumno alumno = null;
			lista_alumnos = new ArrayList<>();
			for (int pos = 0; pos<nombres.length; pos++) {
				alumno = new Alumno (nombres[pos], Integer.parseInt(edades[pos]), Integer.parseInt(notas[pos]));
				lista_alumnos.add(alumno);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lista_alumnos;
	}

	
}

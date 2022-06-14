package ejercicio1.ficheros;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

/**
 * TENEMOS 3 FICHEROS DE PROPIEDADES
 * CON LA MISMA HISTORIA EN DISTINTOS IDIOMAS
 * 
 * RECIBIMOS POR ARGUMNETOS, EL IDIOMA ELEGIDO
 * 	- ESPAÑOL (es)
 * 	- INGLÉS (en)
 * 	- ITALIANO (it)
 * 
 * EL FICHERO, con independencia del idiona, TIENE las
 * siguientes propiedades/claves:
 * 
 * start: contiene el inicio del cuento
 * body: la parte principal 
 * end: el final
 * outfile: nombre de un fichero
 * 
 * TODO: Construir un fichero de salida con el idioma elegido
 * 
 * 
 * 
 * @author USUARIO
 *
 */
public class MainCuento {

	public static void main(String[] args) {
		//args[0] tiene el idioma (es, it, en)
		String nombre_properties = "story_" + "es" +".properties";
		//cargo el properties según el idioma
		Properties p = new Properties();
		p.load(new FileReader(nombre_properties));
		p.getProperty("outfile");
		//leo los valores (accedo por las claves) del cuento
		//escribo el cuento en el fichero de salida
	}
}

package ejercicio1.ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * TENEMOS 3 FICHEROS DE PROPIEDADES CON LA MISMA HISTORIA EN DISTINTOS IDIOMAS
 * 
 * RECIBIMOS POR ARGUMNETOS, EL IDIOMA ELEGIDO - ESPAÑOL (es) - INGLÉS (en) -
 * ITALIANO (it)
 * 
 * EL FICHERO, con independencia del idiona, TIENE las siguientes
 * propiedades/claves:
 * 
 * start: contiene el inicio del cuento body: la parte principal end: el final
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

		String p_start = null;
		String p_body = null;
		String p_end = null;
		String p_outfile = null;

		boolean lectura_propiedades_ok = true;

		// args[0] tiene el idioma (es, it, en)
		String nombre_properties = ".\\midir\\story_" + args[0] + ".properties";
		// cargo el properties según el idioma
		Properties p = new Properties();
		try {
			p.load(new FileReader(nombre_properties));

			// leo los valores (accedo por las claves) del cuento

			p_start = p.getProperty("start");
			p_body = p.getProperty("body");
			p_end = p.getProperty("end");
			p_outfile = p.getProperty("outfile");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			lectura_propiedades_ok = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			lectura_propiedades_ok = false;
		}

		// escribo el cuento en el fichero de salida
		if (lectura_propiedades_ok) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(".\\midir\\" + p_outfile)))) {
				{
					bw.write(p_start);
					bw.newLine();//escribir un salto de línea

					bw.write(p_body);
					bw.newLine();

					bw.write(p_end);
					bw.newLine();

					bw.close();
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}

	}
}
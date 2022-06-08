package ejercicio1.util;

import java.util.List;

import ejercicio1.bean.Alumno;
import ejercicio1.bean.Persona;

public class UtilColecciones {

	public static float calcularNotaMediaAlumno(List<Persona> listaP) {
		float media = 0;
		int nota_aux = 0;
		float total_nota = 0;
		int n_alumnos = 0;

		for (Persona p : listaP) {
			if (p instanceof Alumno a)// Pattern Matching java 14
			{
				nota_aux = a.getNota();
				total_nota = total_nota + nota_aux;
				n_alumnos = n_alumnos + 1;
			}
		}
		if (n_alumnos > 0) {
			media = total_nota / n_alumnos;
		}

		return media;
	}
	
	public static void mostrarListaPersonas (List<Persona> lista_personas)
	{
		for (Persona p : lista_personas) {
			
			System.out.println(p.toString());
		}
		
	}
	
	//TODO haced un método, que dada una lista de personas
	//y una Persona, diga si ésta, pertenece a la lista
	
	public static boolean estaPersonaEnLista (List<Persona> lista_personas, Persona p)
	{
		boolean esta = false;
	
			esta = lista_personas.contains(p);//hace uso del equals
	
		return esta;
		
	}
	
}

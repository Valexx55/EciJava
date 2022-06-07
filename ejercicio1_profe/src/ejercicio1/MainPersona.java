package ejercicio1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Persona persona = new Persona();
		Alumno alumno = new Alumno();

		if (alumno instanceof Persona) {
			System.out.println("alumno es una Persona");
		} else {
			System.out.println("alumno es NO una Persona");
		}

		Persona persona2 = new Persona("VALE", 38);
		String nombre_persona = persona2.getNombre();
		System.out.println("nombre = " + nombre_persona);

		Persona persona3 = (Persona) alumno;// CASTING: convierto al alumno en un objeto de tipo persona
		// Alumno alumno2 = (Alumno)persona;

		// TODO EJEMPLO PRÁCTICO : CREAR UNA LISTA DE PERSONAS Y IMPRIMIR LA NOTA
		// SOLO SI ES DE TIPO ALUMNO :)

		List<Persona> listaPersona = new ArrayList<Persona>();
		Persona personaaux = null;
		Alumno alumno_aux = null;
		int nota_random = 0;
		// vamos a hacer un for e insertando Personas en la lista
		for (int i = 0; i < 5; i++) {
			personaaux = new Persona("persona " + i, i + 20);
			nota_random = (int) (Math.random() * 10);
			alumno_aux = new Alumno("alumno " + i, i + 30, nota_random);
			listaPersona.add(personaaux);
			listaPersona.add(alumno_aux);
		}

		System.out.println("Lista con tamaño = " + listaPersona.size());

		// IMPRIMIR LA LISTA DE PERSONAS - REOCORRIDO
		// for each
		for (Persona p : listaPersona) {
			System.out.println(p.toString());
		}

		float nota_media = MainPersona.calcularNotaMediaAlumno(listaPersona);
		System.out.println("La nota media de los alumnos es = " + nota_media);

	}

	// TODO HACED UN MÉTODO, QUE RECIBA UNA LISTA
	// DE PERSONAS Y DEVUELVA LA NOTA MEDIA
	// DE LOS ALUMNOS
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
}

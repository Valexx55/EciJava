package ejercicio1.util;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import ejercicio1.bean.Alumno;
import ejercicio1.bean.Persona;
import ejercicio1.bean.TipoNota;

public class UtilColeccionesStream {

	public static float calcularNotaMediaAlumno(List<Persona> listaP) {
		double media = 0;

		
		media = listaP.stream()// chorro de personas
				.filter(p -> p instanceof Alumno)// chorro de alumnos
				.mapToInt(a -> ((Alumno) a).getNota())// chorro de notas de alumnos
				.average().getAsDouble();// media - final-

		return (float) media;
	}

	public static void mostrarListaPersonas(List<Persona> lista_personas) {

		lista_personas.forEach(p -> {
			p.toString();
		});
		
		lista_personas.forEach(System.out::print);


	}

	public static List<Alumno> sumarPuntoAlumnos(List<Alumno> le) {
		List<Alumno> ls = null;

		ls = le.stream().map(alumno -> {
			int nota = alumno.getNota();
			if (nota < 10) {
				nota++;
			}
			alumno.setNota(nota);
			return alumno;
		}).collect(Collectors.toList());//Interesante clase que implementa Collector de un Stream te saca una colección


		return ls;

	}

	

	public static boolean estaPersonaEnLista(List<Persona> lista_personas, Persona p) {
		boolean esta = false;

			esta = lista_personas.stream().anyMatch(pe -> pe.equals(p));

		return esta;

	}

	public static boolean hayPersonasConNombresde4(List<Persona> lista_personas) {
		boolean hay = false;

			hay = lista_personas.stream().anyMatch(persona -> persona.getNombre().length() == 4);

		return hay;

	}

	// MÉTODO QUE RX UNA LISTA DE ALUMNOS Y DIGA CUÁNTOS TIENEN SOBRE

	public static void mostrarMapaPersonas(Map<Integer, Persona> mapa_personas) {
		mapa_personas.forEach((id, persona) -> System.out.println(persona));
	}

	public static long cuantosTienenSobresaliente(List<Alumno> alumno) {
		// dime si hay algún nombre con longitud = 4
		long cont = alumno.stream()// chorro de alumnos
				.filter(al -> al.getNota() > 8) // los que tienen mayor 8
				.count(); // me cuentas cuantos
		return cont;

	}
	
	public static int numeroSobresalientes(List<Alumno> lista_alumnos) {
		int numero_sobre = 0;
		numero_sobre = (int) lista_alumnos.stream()
				.filter(persona -> TipoNota.traduceNota(persona.getNota()).equals(TipoNota.SOBRESALIENTE)).count();
		return numero_sobre;
	}

	
	public static Optional<Persona> obtenerPrimerAlumno (List<Persona> lp)
	{
		Optional<Persona> op = null;
		
			op = lp.stream()
					.filter(p -> p instanceof Alumno)
					.findFirst();
			
		return op;
	}

	
	public static void mostrarMapaNotasAlumnos(Map<Integer, List<Alumno>> mapaNotas) {
		
		mapaNotas.forEach((nota, lista) -> System.out.println(lista));
	}

	
	public static Map<Integer, List<Alumno>> obtenerMapaNotasAlumnos(List<Alumno> listaAlumnos) {
		Map<Integer, List<Alumno>> mapa_notas = null;

			mapa_notas = listaAlumnos.stream().collect(Collectors.groupingBy(Alumno::getNota));

			
		return mapa_notas;
	}

	public static TipoNota obtenerNotaModa(Map<Integer, List<Alumno>> mapaNotas) {
		TipoNota tipoNotaModa = null;
		
		
			int notamax = mapaNotas.values()
				.stream()
				.max((l1, l2)->l1.size()-l2.size())
				.get()
				.get(0)
				.getNota();
			
			tipoNotaModa = TipoNota.traduceNota(notamax);

		return tipoNotaModa;
	}

	

}

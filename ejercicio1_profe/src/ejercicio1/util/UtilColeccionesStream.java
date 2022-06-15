package ejercicio1.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import ejercicio1.bean.Alumno;
import ejercicio1.bean.Persona;
import ejercicio1.bean.TipoNota;

public class UtilColeccionesStream {

	public static float calcularNotaMediaAlumno(List<Persona> listaP) {
		double media = 0;
			
		//1 me quedo con los alumnos 
		//qué metodo de Stream puedo usar? - filter
		
		//2 me quedo con la nota de los alumnos
		//map
			media = listaP.stream()//chorro de personas
			.filter(p -> p instanceof Alumno)//chorro de alumnos
			.mapToInt(a -> ((Alumno) a).getNota())//chorro de notas de alumnos
			.average()
			.getAsDouble();//media - final-
		
		return (float)media;
	}
	
	public static void mostrarListaPersonas (List<Persona> lista_personas)
	{
//		for (Persona p : lista_personas) {
//			
//			System.out.println(p.toString());
//		}
		
		lista_personas.forEach(
				p -> 
				{
					p.toString();
				}
				);
		
		//lista_personas.stream().filter(p -> (p instanceof Alumno)).count();
		
	}
	
	//hacer un método, que sume 1 punto a la nota de todos los alumnos
	public static List<Alumno> sumarPuntoAlumnos (List<Alumno> le)
	{
		List<Alumno> ls = null;
		
			Stream<Alumno> se = le.stream().map(alumno -> { 
				int nota = alumno.getNota();
					if (nota <10)
					{
						nota++;
					}
					alumno.setNota(nota);
				return alumno;
			});
			
			ls = se.toList();
		
		return ls;
		
	}
	
	//TODO haced un método, que dada una lista de personas
	//y una Persona, diga si ésta, pertenece a la lista
	
	public static boolean estaPersonaEnLista (List<Persona> lista_personas, Persona p)
	{
		boolean esta = false;
	
			//intentead haced este con anyMatch
			esta =lista_personas.stream().anyMatch(pe -> pe.equals(p));
	
		return esta;
		
	}
	
	public static boolean hayPersonasConNombresde4 (List<Persona> lista_personas)
	{
		boolean hay = false;
	
			//intentead haced este con anyMatch
			hay = lista_personas.stream().anyMatch(
					persona -> persona.getNombre().length()==4
					);
	
		return hay;
		
	}
	
	public static void mostrarMapaPersonas (Map<Integer, Persona> mapa_personas)
	{
		Set<Integer> conjunto = mapa_personas.keySet();
		Iterator<Integer> it = conjunto.iterator();
		
		System.out.println("RECORRO EL HASHMAP ENTERO");
		while (it.hasNext())
		{
			Integer clave_actual = it.next();
			Persona p = mapa_personas.get(clave_actual);
			System.out.println(p.toString());
		}
	}
	
	public static void mostrarMapaNotasAlumnos (Map<Integer, List<Alumno>> mapaNotas)
	{
		Set<Integer> conjunto = mapaNotas.keySet();
		Iterator<Integer> it = conjunto.iterator();
		
		
		while (it.hasNext())
		{
			Integer clave_actual = it.next();
			System.out.println("ALUMNOS CON NOTA " + clave_actual);
			List<Alumno> la = mapaNotas.get(clave_actual);
			System.out.println(la);
		}
	}
	
	//TODO haced un método que reciba una lista de alumnos
	//y los devuelva agrupados por nota en un mapa
	
	//si existe esa nota en el mapa
	//obtengo la lista, añado al alumno
//si no
	//creo nueva lista
	//añado alumno a esa lista
	//creo clave en el mapa
	public static Map<Integer, List<Alumno>> obtenerMapaNotasAlumnos(List<Alumno> listaAlumnos) {
		Map<Integer, List<Alumno>> mapa_notas = null;
		
			mapa_notas = new HashMap<Integer, List<Alumno>>();
		
			for (Alumno a : listaAlumnos)
			{
				List<Alumno> la = mapa_notas.get(a.getNota());
				if (la!=null)
				{
					//ya existía
					//mapa_notas.get(a.getNota()).add(a);
					la.add(a);
				}else {
					//nueva nota
					List<Alumno> lista_nueva = new ArrayList<Alumno>();
					lista_nueva.add(a);
					mapa_notas.put(a.getNota(), lista_nueva);
					
				}
			}
		
		return mapa_notas;
	}
	
	public static TipoNota obtenerNotaModa(Map<Integer, List<Alumno>> mapaNotas) {
		TipoNota tipoNotaModa = null;
		int max_alumnos = 0; int max_nota = 0;
		
			Collection<List<Alumno>> coleccion = mapaNotas.values();
			for (List<Alumno> l : coleccion)
			{
				if (l.size()>max_alumnos)
				{
					max_alumnos = l.size();
					max_nota = l.get(0).getNota();
				}
			}
		
			System.out.println("NOTA MÁS REPE = " + max_nota);
			tipoNotaModa = TipoNota.traduceNota(max_nota);
		
		return tipoNotaModa;
	}
	
	public static List<Alumno> obtenerListaALumnos (int tamnio)
	{
		List<Alumno> listaAlumnos = new ArrayList<Alumno>();
		Alumno alumno_aux = null;
		int nota_random = 0;
		int edad_random = 0;
		for (int i = 0; i < tamnio; i++) {
			edad_random = (int) (Math.random() * 100);
			nota_random = (int) (Math.random() * 10);
			alumno_aux = new Alumno("alumno " + i, edad_random, nota_random);
			listaAlumnos.add(alumno_aux);
		}
		return listaAlumnos;
	}
	
}

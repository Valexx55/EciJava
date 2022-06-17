package ejercicio1.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import ejercicio1.bean.Alumno;
import ejercicio1.bean.Persona;
import ejercicio1.exception.NotaException;
import ejercicio1.orden.ComparadorPersona;
import ejercicio1.util.UtilColecciones;
import ejercicio1.util.UtilColeccionesStream;

public class MainPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		int edad_random = 0;
		// vamos a hacer un for e insertando Personas en la lista
		for (int i = 0; i < 5; i++) {
			edad_random = (int) (Math.random() * 100);
			personaaux = new Persona("persona " + i, edad_random); 
			nota_random = (int) (Math.random() * 10);
			try {
				alumno_aux = new Alumno("alumno " + i, i + 30, nota_random);
			} catch (NotaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			listaPersona.add(personaaux);
			listaPersona.add(alumno_aux);
		}

		System.out.println("Lista con tamaño = " + listaPersona.size());

		// IMPRIMIR LA LISTA DE PERSONAS - REOCORRIDO
		// for each
		//reocorrido por el orden de insercción
		System.out.println("Mostrando por orden de inserción");
		UtilColecciones.mostrarListaPersonas(listaPersona);
		
		listaPersona.sort(new ComparadorPersona());
		listaPersona.sort ((a,b)//paramétros de entrada
				->
				{//inicio
					return (a.getEdad()-b.getEdad());
				}//fin
			);
		
		
		System.out.println("\n\n Mostrando por orden de EDAD - orden total");
		UtilColecciones.mostrarListaPersonas(listaPersona);
		
		Collections.sort(listaPersona);
		
		//MainPersona mainPersona = new MainPersona();
		//listaPersona.sort(mainPersona::comparar);
		System.out.println("\n\n Mostrando por orden ALFABÉTICO - Nombre - orden natural");
		UtilColecciones.mostrarListaPersonas(listaPersona);
		

		float nota_media = UtilColecciones.calcularNotaMediaAlumno(listaPersona);
		System.out.println("La nota media de los alumnos es = " + nota_media);
		
		int n1 = 3;
		int n2 = 3;
		if (n1==n2)
		{
			System.out.println("los n son iguales");
		} else {
			System.out.println("los n NO son iguales");
		}
		
		Persona persona4 = new Persona("PEPE", 12);
		Persona persona5 = new Persona("PEPE", 12);
		
		if (persona4.equals(persona5))//al comparar objetos, usar equals
		{
			System.out.println("los personas son iguales");
		} else {
			System.out.println("los personas NO son iguales");
		}
		
		listaPersona.add(persona4);
		boolean esta = UtilColecciones.estaPersonaEnLista(listaPersona, persona4);
		if (esta)
		{
			System.out.println("LA PERSONA PERTENCE A LA LISTA");
		} else {
			System.out.println("LA PERSONA no PERTENCE A LA LISTA");
		}
		
		List<Alumno> la = UtilColecciones.obtenerListaALumnos(15);
		System.out.println("MOSTRANDO LISTA ALUMNOS NOTAS");
		System.out.println(la);
		Optional<Alumno> oa = UtilColecciones.buscarPrimerAlumnoSobresaliente(la);
		if (oa.isPresent())
		{
			Alumno alumno_encontrado = oa.get();
			System.out.println(alumno_encontrado);
		} else {
			System.out.println("NO HAY NINGUNO de SOBRESALIENTE");
		}
		
		List<Alumno> lista_notas_mas =  UtilColeccionesStream.sumarPuntoAlumnos(la);
		System.out.println("MOSTRANDO LISTA ALUMNOS NOTAS+1");
		System.out.println(lista_notas_mas);
		
	}

	
	
}

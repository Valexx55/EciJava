package ejercicio1.main;

import java.util.HashMap;
import java.util.Map;

import ejercicio1.bean.Persona;

public class MainMapas {
	
	public static void main(String[] args) {
		Persona p1 = new Persona("Felix", 18);
		Persona p2 = new Persona("Sonia", 20);
		Persona p3 = new Persona("Oscar", 21);
		Persona p4 = new Persona("JOse", 22);
		Persona p5 = new Persona("Vale", 23);
		
		Map<Integer, Persona> mapa_personas = new HashMap<Integer, Persona>();
		
		mapa_personas.put(p1.getId(), p1);
		mapa_personas.put(p2.getId(), p2);
		mapa_personas.put(p3.getId(), p3);
		mapa_personas.put(p4.getId(), p4);
		mapa_personas.put(p5.getId(), p5);
		
		System.out.println("HASHMAP PERSONAS");
		System.out.println(mapa_personas);
		
		Persona nueva = mapa_personas.get(5);
		System.out.println("NUeva = " +nueva);
	
	}

}

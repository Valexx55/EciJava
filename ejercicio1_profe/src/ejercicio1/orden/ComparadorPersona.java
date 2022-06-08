package ejercicio1.orden;

import java.util.Comparator;

import ejercicio1.bean.Persona;

public class ComparadorPersona implements Comparator<Persona> {
	

		@Override
		public int compare(Persona o1, Persona o2) {
			int result  = 0;
			
				result = o1.getEdad() -  o2.getEdad();
			
			return result;
		}
}

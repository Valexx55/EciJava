package ejercicio1;

import java.util.Comparator;

public class ComparadorPersona implements Comparator<Persona> {
	

		@Override
		public int compare(Persona o1, Persona o2) {
			int result  = 0;
			
				result = o1.getEdad() -  o2.getEdad();
			
			return result;
		}
}

package ejercicio1;

import java.util.Comparator;

public class ComparadorAlumnos implements Comparator<Alumno>{

	@Override
	public int compare(Alumno o1, Alumno o2) {
		int resultado = 0;
		
			/*if (o1.getNota()>o2.getNota())
			{
				resultado = 1;
			} else if (o1.getNota()<o2.getNota())
			{
				resultado = -1;
			} else resultado = 0;*/
			
			resultado = o1.getNota()-o2.getNota();
		
		return resultado;
	}

}

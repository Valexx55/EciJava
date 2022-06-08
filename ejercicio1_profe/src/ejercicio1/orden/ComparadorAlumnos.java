package ejercicio1.orden;

import java.util.Comparator;

import ejercicio1.bean.Alumno;

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

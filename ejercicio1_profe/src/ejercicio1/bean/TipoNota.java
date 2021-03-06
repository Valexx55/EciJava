package ejercicio1.bean;

import ejercicio1.exception.NotaException;

//El Enum es el tipo ?ptimo cuando el valor de un dato
//oscila en un rango limitado de valores
public enum TipoNota {SOBRESALIENTE, NOTABLE, BIEN, APROBADO, SUSPENSO;
	
	public static TipoNota traduceNota (int nota) throws NotaException
	{
		TipoNota tipoNotaDevuelto = null;
		
			switch (nota) {
			case 10:
			case 9: tipoNotaDevuelto = TipoNota.SOBRESALIENTE;
				break;
			case 8:
			case 7: tipoNotaDevuelto = TipoNota.NOTABLE;
				break;
			case 6: tipoNotaDevuelto = TipoNota.BIEN;
			break;
			case 5: tipoNotaDevuelto = TipoNota.APROBADO;
			break;
			case 4:
			case 3:
			case 2:
			case 1:
			case 0: tipoNotaDevuelto = TipoNota.SUSPENSO;
			break;
			default: //si no coincidimos con ninguno de las anteriores
				throw new NotaException();
			}
		
		
		return tipoNotaDevuelto;
	}

}

package ejercicio1.bean;


//El Enum es el tipo óptimo cuando el valor de un dato
//oscila en un rango limitado de valores
public enum TipoNota {SOBRESALIENTE, NOTABLE, BIEN, APROBADO, SUSPENSO;
	
	public static TipoNota traduceNota (int nota)
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
			}
		
		
		return tipoNotaDevuelto;
	}

}

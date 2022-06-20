package ejercicio_imc.bean;

public enum TipoIMC {

	DESNUTRIDO, BAJOPESO, NORMAL, SOBREPESO, OBESO;

	public static TipoIMC traduceIMC(float imc) {
		TipoIMC tipo = null;

		if (imc < 16) {
			tipo = TipoIMC.DESNUTRIDO;
		} else if (imc >= 16 && imc < 18) {
			tipo = TipoIMC.BAJOPESO;
		} else if (imc >= 18 && imc < 25) {
			tipo = TipoIMC.NORMAL;
		} else if (imc >= 25 && imc < 31) {
			tipo = TipoIMC.SOBREPESO;
		} else if (imc >= 31) {
			tipo = TipoIMC.OBESO;

		}

		return tipo;
	}
}
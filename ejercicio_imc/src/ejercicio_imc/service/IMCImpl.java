package ejercicio_imc.service;

import ejercicio_imc.bean.Persona;

public class IMCImpl implements InterfazIMC {

	@Override
	public float calculaIMC(Persona persona) {
		
		//IMC : PESO (KG) / ALTURA * ALTURA (M)
		float resultado_imc = 0;
		
			resultado_imc = persona.getPeso()/(persona.getAltura()*persona.getAltura());
		
		return resultado_imc;
	}

}

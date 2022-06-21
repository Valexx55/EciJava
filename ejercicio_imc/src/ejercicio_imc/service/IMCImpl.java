package ejercicio_imc.service;

import ejercicio_imc.bean.ImcResultado;
import ejercicio_imc.bean.Persona;
import ejercicio_imc.bean.TipoIMC;

public class IMCImpl implements InterfazIMC {

	@Override
	public ImcResultado calculaIMC(Persona persona) {
		
		ImcResultado imcResultado = null;
		float resultado_imc = 0;
		
			resultado_imc = persona.getPeso()/(persona.getAltura()*persona.getAltura());
			TipoIMC imc_nom = TipoIMC.traduceIMC(resultado_imc);
			imcResultado = new ImcResultado(persona.getPeso(), persona.getAltura(), resultado_imc, imc_nom, persona.getNombre());
		
		return imcResultado;
	}

}

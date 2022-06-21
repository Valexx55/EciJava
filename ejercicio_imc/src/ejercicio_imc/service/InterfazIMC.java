package ejercicio_imc.service;

import ejercicio_imc.bean.ImcResultado;
import ejercicio_imc.bean.Persona;

public interface InterfazIMC {
	
	ImcResultado calculaIMC(Persona persona);

}

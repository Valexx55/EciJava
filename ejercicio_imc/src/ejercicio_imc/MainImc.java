package ejercicio_imc;

import java.util.Random;

import org.apache.log4j.Logger;

import ejercicio_imc.bean.ImcResultado;
import ejercicio_imc.bean.Persona;
import ejercicio_imc.service.IMCImpl;
import ejercicio_imc.service.InterfazIMC;

public class MainImc {
	
	private static Logger log = Logger.getLogger("mylog");
	
	//TODO db properties y crear esquema
	// terminar de definir la ontologia
	
	public static void main(String[] args) {
		
		
		//TODO HACED UNA IMPLENTACIÓN Y UNA PRUEBA
		//DEL TIPO public interface InterfazIMC 
		
	    InterfazIMC imc =  new IMCImpl();
	    Persona p = new Persona();
	    Random random = new Random();
	    float altura = random.nextFloat(1.1f, 2.20f);
	    float peso = random.nextFloat(30, 180);
	    p.setAltura(altura);
	    p.setPeso(peso);
	    ImcResultado imcResultado = imc.calculaIMC(p);
	    System.out.println("Resultado = " + imcResultado);
		
		/*try {
		    //INFERENCIA DE TIPOS - VAR
			var nombre = "MARTA";
			log.debug("El nombre es = " + nombre);
			args[0].length();
		} catch (Exception e) {
			log.error("ERROR", e);
		}*/
	}

}

package ejercicio_imc;

import org.apache.log4j.Logger;

public class MainImc {
	
	private static Logger log = Logger.getLogger("mylog");
	
	//TODO db properties y crear esquema
	// terminar de definir la ontologia
	
	public static void main(String[] args) {
		try {
			var nombre = "MARTA";
			log.debug("El nombre es = " + nombre);
			args[0].length();
		} catch (Exception e) {
			// TODO: handle exception
			log.error("ERROR", e);
		}
	}

}

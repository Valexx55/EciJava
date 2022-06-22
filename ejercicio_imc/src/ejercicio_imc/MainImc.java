package ejercicio_imc;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import ejercicio_imc.bean.ImcResultado;
import ejercicio_imc.bean.Persona;
import ejercicio_imc.repository.IMCDao;
import ejercicio_imc.service.IMCImpl;
import ejercicio_imc.service.InterfazIMC;

public class MainImc {
	
	private static Logger log = Logger.getLogger("mylog");
	
	//TODO db properties y crear esquema
	// terminar de definir la ontologia
	
	public static void main(String[] args) {
		
		
	    InterfazIMC imc =  new IMCImpl();
	    
	    Persona p = new Persona();
	    Random random = new Random();
	    float altura = random.nextFloat(1.1f, 2.20f);
	    float peso = random.nextFloat(30, 180);
	    p.setAltura(altura);
	    p.setPeso(peso);
	    
//	    /*Stream.generate(Persona::new)
//	    .peek(persona-> persona.setAltura(altura))
//	    .takeWhile( persona -> persona.getAltura()<2).toList();*/
//	    
//	    List<Float> lista_float = 
//	    		Stream.generate(new Float (random.nextFloat(30, 180)))
//	    		.t
//	    
	    ImcResultado imcResultado = imc.calculaIMC(p);
	    System.out.println("Resultado = " + imcResultado);
	    
	    IMCDao imcDao = new IMCDao();
	    try {
	    	List<ImcResultado> limc = imcDao.recuperarTodos();
	    	if (limc.isEmpty())
	    	{
	    		log.debug("Lista resultados vacía");
	    		imcDao.insertarImcResultado(imcResultado);
	    	}
	    	else {
	    		log.debug("Lista recuperada");
	    		log.debug(limc);
	    	}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

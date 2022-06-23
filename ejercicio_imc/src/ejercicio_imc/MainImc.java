package ejercicio_imc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import ejercicio_imc.bean.ImcResultado;
import ejercicio_imc.bean.Persona;
import ejercicio_imc.repository.IMCDao;
import ejercicio_imc.repository.IMCDao2;
import ejercicio_imc.service.IMCImpl;
import ejercicio_imc.service.InterfazIMC;

public class MainImc {
	
	private static Logger log = Logger.getLogger("mylog");
	
	//TODO db properties y crear esquema
	// terminar de definir la ontologia
	
	public static void main(String[] args) {
		
		
	    /*InterfazIMC imc =  new IMCImpl();
	    
	    Persona p = new Persona();
	    Random random = new Random();
	    float altura = random.nextFloat(1.1f, 2.20f);
	    float peso = random.nextFloat(30, 180);
	    p.setAltura(altura);
	    p.setPeso(peso);
	    p.setNombre("PEPE");*/
	    
//	    /*Stream.generate(Persona::new)
//	    .peek(persona-> persona.setAltura(altura))
//	    .takeWhile( persona -> persona.getAltura()<2).toList();*/
//	    
//	    List<Float> lista_float = 
//	    		Stream.generate(new Float (random.nextFloat(30, 180)))
//	    		.t
//	    
	   /* ImcResultado imcResultado = imc.calculaIMC(p);
	    System.out.println("Resultado = " + imcResultado);
	    
	    IMCDao imcDao = new IMCDao();
	    try {
	    
	    	imcDao.insertarImcResultado(imcResultado);
	    	List<ImcResultado> limc = imcDao.recuperarTodos();
	    	
	    	log.debug("Lista recuperada");
	    	log.debug(limc);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//sección Oscar
	   /* try {
	    	List<ImcResultado> limc = imcDao.recuperarRangoPeso(30,200);
	    	
	    	if (limc.isEmpty()) {
	    		log.debug("La lista esta vacia");

	    	}
	    	else {
	    		System.out.println(limc);
	    	}
	    	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
	    
	    //seccion Jose
	    try {
	    	 String nombre = imcDao.recuperarNombreMaxPeso();
	    	 if (nombre!= null)
	    	 {
	    		 System.out.println("NOMBRE MAX PESO = " + nombre);
	    	 } else 
	    		 {
	    		 System.out.println("No se ha encontrado ningun registro");
	    	 }
	    	
	    	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/	 
		
		try {
			
			InterfazIMC imcservice = new IMCImpl();
			IMCDao2 imcDao2 = new IMCDao2();
			ImcResultado imcResultadoAux;
		    List<Persona> lp =  obtenerListaConStreams();
		    for (Persona p : lp)
		    {
		    	imcResultadoAux = imcservice.calculaIMC(p);
		    	imcResultadoAux.setPersona(p);
		    	//imcDao.insertarImcResultado(imcResultadoAux);
		    }
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("ERROR INSERTANDO LISTA PERSONAS", e);
		}
		
	    
	   
	}


	public static List<Persona> obtenerListaConStreams ()
	{
		List<Persona> lp = null;
		
		float max_peso = 200;
		float min_peso = 40;
		
		float max_altura = 2.20f;
		float min_altura = 1.20f;
		
		Random r = new Random ();
		List<String> listanombres = listaNombres();
		System.out.println(listanombres);
		
		 lp = Stream
		.generate(Persona::new) // chorro Personas
		.peek(p -> p.setAltura(r.nextFloat(min_altura, max_altura)))
		.peek(p -> p.setPeso(r.nextFloat(min_peso, max_peso)))
		.peek(p -> p.setNombre(listanombres.get(p.getId())))
		.peek(p -> p.setFecha_nac(new Date()))//naces hoy!
		.takeWhile(p-> p.getId()<20)
		.toList();
		 
		 System.out.println("LISTA PERSONAS RANDOM = " + lp);
		 return lp;
	}
	
    public static List<String> listaNombres() {

        List<String> listaNombres = null;

        Path p = Path.of("nombres.txt");
        try {
			listaNombres = Files.readAllLines(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return listaNombres;
    }
        
        /*try (BufferedReader br = new BufferedReader(new FileReader(new File("nombres.txt")))) {

             String linea = null;

             while (linea != null) {

                  linea = br.readLine();

                  if (linea != null)

                       listaNombres.add(linea);

             }

        } catch (Exception e) {

             e.printStackTrace();

        }



        return listaNombres;

    }*/
}

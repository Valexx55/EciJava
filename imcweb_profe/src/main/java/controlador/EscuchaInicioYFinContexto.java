package controlador;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

import bean.ImcResultado;
import servicio.ImcService;

/**
 * Application Lifecycle Listener implementation class EscuchaInicioYFinContexto
 *
 */
@WebListener
public class EscuchaInicioYFinContexto implements ServletContextListener {

	private static Logger log = Logger.getLogger("mylog");
    /**
     * Default constructor. 
     */
    public EscuchaInicioYFinContexto() {
        // TODO Auto-generated constructor stub
    }
    
    

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	log.debug("app finalizada SE HA destruido EL CONTEXTO contextDestroyed");
    	
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	log.debug("app iniciada SE HA LEVANTADO EL CONTEXTO contextInitialized");
    	sce.getServletContext().setAttribute("HORA_INICIO", new Date());
    	
    	ImcService imcService = new   ImcService();
    	List<ImcResultado> listaImc = null;
		try {
			listaImc = imcService.recuperarTodos();
		} catch (Exception e) {
			log.error("error en recuperar los imc " + e);
			e.printStackTrace();
		}		
    	//creo el atributo lista y guardo la lista
    	sce.getServletContext().setAttribute("LISTA", listaImc);
    	
    	//le pido que me de el atributo LISTA
    	log.debug( sce.getServletContext().getAttribute("LISTA"));    	
    }
	
}

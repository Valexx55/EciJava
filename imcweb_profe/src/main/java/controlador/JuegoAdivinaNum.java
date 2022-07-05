package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class JuegoAdivinaNum
 */
@WebServlet("/JuegoAdivinaNum")
public class JuegoAdivinaNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger("mylog");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JuegoAdivinaNum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// con true siempre le abro una nueva sesi�n  
		// con false si no la tiene me da la nueva sesi�n 
		HttpSession sesion = request.getSession(false);

		//tiene una sesi�n v�lida si tiene sesi�n (primer and) y "el saco de la sesi�n" tiene algo (no ha sido limpiado con invalidate)
		if (sesion != null && sesion.getAttribute("INTENTOS")!=null) 
		{
			log.debug("estamos en una partida con una sesi�n v�lida");
			sesion.setAttribute("INTENTOS", (int) sesion.getAttribute("INTENTOS") + 1);
			log.debug(" SERVET JuegoAdivina. N�mero de intentos -->" + sesion.getAttribute("INTENTOS"));
			int numero_usuario = Integer.parseInt(request.getParameter("numero"));
			int num_adivinar = (int) sesion.getAttribute("NUMEROGUARDADO");
			if (numero_usuario == num_adivinar) {
				request.setAttribute("ganador", true);
				request.setAttribute("mensaje", "ERES EL NUMBER ONE");
				sesion.invalidate(); // La sesi�n sigue siendo v�lida solo vacia los atributos
				//sesion = null;
				//TODO MEJORA REDIRIGIR A P�GINA DE �XITO
			} else {
				int nintentos = (int) sesion.getAttribute("INTENTOS");
				if (nintentos > 4) {
					request.setAttribute("mensaje", "FIN DE LA PARTIDA, ERES UN IN�TIL ");
					request.setAttribute("ganador", false);
					request.setAttribute("restan_intentos", 0);
					sesion.invalidate(); // La sesi�n sigue siendo v�lida solo vacia los atributos
					//sesion = null;
					//TODO MEJORA REDIRIGIR A P�GINA DE ERROR
				} else {
					sesion.setAttribute("INTENTOS", nintentos);
					nintentos = 5 - nintentos;					
					request.setAttribute("mensaje", "int�ntalo otra vez");
					request.setAttribute("restan_intentos", nintentos);
					request.setAttribute("ganador", false);
				}
			}			
		} else  {		
			log.debug("hacemos una partida nueva: la sesi�n es null no existe o est� va�c");
			sesion = request.getSession();// le creo una nueva sesion
			request.setAttribute("restan_intentos", 5); 
			iniciarPartida(sesion);// inicio partida
			
		}
		request.getRequestDispatcher("juego.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void iniciarPartida(HttpSession sesion) {
		sesion.setAttribute("INTENTOS", 0);
		sesion.setAttribute("NUMEROGUARDADO", (int) (Math.random() * 10));		
		log.debug("INICIO JUEVO");
		log.debug("NUMERO DE A ADIVINAR-->" + sesion.getAttribute("NUMEROGUARDADO"));
	}

}

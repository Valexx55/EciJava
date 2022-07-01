package controlador;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import bean.ImcResultado;
import servicio.ImcService;

/**
 * Servlet implementation class ObtenerPersonasEnRangoJSP
 */
@WebServlet("/ObtenerPersonasEnRangoJSP")
public class ObtenerPersonasEnRangoJSP extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger("mylog");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObtenerPersonasEnRangoJSP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Date fecha_inicio_servidor = (Date) getServletContext().getAttribute("HORA_INICIO");
		log.debug( "FECHA INICIO SERVLET " +fecha_inicio_servidor);
		
		String min = request.getParameter("min");
		String max = request.getParameter("ma");
		
		try {
			ImcService imcService = new ImcService();
			List<ImcResultado> lis =  imcService.recuperarRangoPeso(Float.parseFloat(min), Float.parseFloat(max));									
			
			request.setAttribute("listap", lis);
			request.setAttribute("max", max);
			request.setAttribute("min", min);
			request.getRequestDispatcher("lista_personas_rango.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e);
			//request.getRequestDispatcher("error.jsp").forward(request, response);
			response.sendRedirect("error.jsp");
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

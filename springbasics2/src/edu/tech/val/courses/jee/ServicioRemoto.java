package edu.tech.val.courses.jee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class ServicioRemoto
 */
@WebServlet("/ServicioRemoto")
public class ServicioRemoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Servicio servicio;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		servicio = (Servicio)ac.getBean("servis");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServicioRemoto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Object o = servicio.getProceso().ejecuta();
		request.setAttribute("valorsalida", o.toString());
		request.getRequestDispatcher("salida.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

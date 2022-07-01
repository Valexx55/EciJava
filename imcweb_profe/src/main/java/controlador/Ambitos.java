package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ambitos
 */
@WebServlet("/Ambitos")
public class Ambitos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ambitos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (null!=request.getAttribute("edad"))
		{
			request.setAttribute("edad", (int) request.getAttribute("edad")+1);
		} else 
			{
				request.setAttribute("edad", 1);
			}
		
		HttpSession sesion = request.getSession(true);
		
		if (null!=sesion.getAttribute("edad"))
		{
			sesion.setAttribute("edad", (int) sesion.getAttribute("edad")+1);
		} else 
			{
			sesion.setAttribute("edad", 1);
			}
		
		
		if (null!=getServletContext().getAttribute("edad"))
		{
			getServletContext().setAttribute("edad", (int) getServletContext().getAttribute("edad")+1);
		} else 
			{
			getServletContext().setAttribute("edad", 1);
			}
		
		request.getRequestDispatcher("ambitos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

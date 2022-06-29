package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import bean.ImcInput;
import bean.Persona;

/**
 * Servlet implementation class InsertarPersona
 */
@WebServlet("/InsertarPersona")
public class InsertarPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger("mylog");
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertarPersona() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			log.debug("Entrando en doPost");
			String persona_json = request.getReader().readLine();
			System.out.println("persona rx = " + persona_json);
			Gson gson = new Gson();
			ImcInput p = gson.fromJson(persona_json, ImcInput.class);
			System.out.println("Input rx objeto = " + p);
			// TODO INSERTAR PERSONA
		} catch (JsonSyntaxException e) {
			// TODO: devolver un 400 error en la peticon
		} catch (Exception e) {
			// TODO: devolver un 500 error en la peticon
		}
	}

}

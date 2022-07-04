package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.ImcResultado;
import servicio.ImcService;

/**
 * Servlet implementation class ObtenerPersonasEnRangoJSON2
 */
@WebServlet("/ObtenerPersonasEnRangoJSON2")
public class ObtenerPersonasEnRangoJSON2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ObtenerPersonasEnRangoJSON2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String min = request.getParameter("min");
		String max = request.getParameter("max");

		float minf = Float.parseFloat(min);
		float maxf = Float.parseFloat(max);

		try {
			ImcService imcService = new ImcService();
			List<ImcResultado> lis = null;

			lis = new ArrayList<ImcResultado>();
			lis = (List<ImcResultado>) getServletContext().getAttribute("LISTA");
			lis = lis.stream().filter(imc -> imc.getPeso() >= minf && imc.getPeso() <= maxf).toList();

			Gson gson = new Gson();
			String lista_json = gson.toJson(lis);// serializar a JSON
			response.setContentType("application/json;charset=UTF-8");// tipo MIME
			response.getWriter().print(lista_json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

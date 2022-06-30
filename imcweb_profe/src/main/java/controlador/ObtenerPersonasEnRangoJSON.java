package controlador;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import bean.ImcResultado;
import bean.TipoIMC;
import servicio.ImcService;

/**
 * Servlet implementation class ObtenerPersonasEnRango
 */
//http://localhost:8080/ObtenerPersonasEnRango?min=5&max=100
@WebServlet("/ObtenerPersonasEnRangoJSON")
public class ObtenerPersonasEnRangoJSON extends HttpServlet {
	
	private static final long serialVersionUID = 1L;	
	
	private static Logger log = Logger.getLogger("mylog");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObtenerPersonasEnRangoJSON() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String min = request.getParameter("min");
		String max = request.getParameter("max");
		
		try {
			ImcService imcService = new ImcService();
			List<ImcResultado> lis =  imcService.recuperarRangoPeso(Float.parseFloat(min), Float.parseFloat(max));
			Gson gson = new Gson();
			String lista_json = gson.toJson(lis);//serializar a JSON
			response.setContentType("application/json;charset=UTF-8");//tipo MIME
			response.getWriter().print(lista_json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

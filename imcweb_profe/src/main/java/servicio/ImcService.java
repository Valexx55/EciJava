package servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import bean.ImcInput;
import bean.ImcResultado;
import bean.Persona;
import bean.TipoIMC;
import repositorio.ImcRepository;

public class ImcService {

	private static Logger log = Logger.getLogger("mylog");

	public List<ImcResultado> recuperarRangoPeso(float min_peso, float max_peso) throws Exception {

		List<ImcResultado> list = null;

		ImcRepository imcRepository = new ImcRepository();
		list = imcRepository.recuperarRangoPesoDAO(min_peso, max_peso);

		return list;

	}

	public ImcResultado pasarImcInputResultado(ImcInput imcInput) throws Exception {
		ImcResultado imcResultado = null;
		Persona persona = new Persona(imcInput.getId(), imcInput.getNombre(), imcInput.getPeso(),
				imcInput.getEstatura(), new Date(), null);

		float imc = imcInput.getPeso() / (imcInput.getEstatura() * imcInput.getEstatura());

		imcResultado = new ImcResultado(0, imcInput.getPeso(), imcInput.getEstatura(), imc, TipoIMC.traduceIMC(imc),
				persona, new Date());

		ImcRepository imcRepository = new repositorio.ImcRepository();
		imcRepository.registrarResultado(imcResultado);

		return imcResultado;
	}
	   public List<ImcResultado> recuperarTodos () throws Exception
		{

	        List<ImcResultado> list = null;
	        	
	        	ImcRepository imcRepository = new ImcRepository();
	        	list = imcRepository.recuperarTodos();
	 
	        return list;

		}

}

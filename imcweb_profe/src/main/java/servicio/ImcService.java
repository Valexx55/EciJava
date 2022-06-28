package servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import bean.ImcResultado;
import repositorio.ImcRepository;

public class ImcService {
	
	private static Logger log = Logger.getLogger("mylog");
	
	public List<ImcResultado> recuperarRangoPeso (float min_peso, float max_peso) throws Exception
	{

        List<ImcResultado> list = null;
        	
        	ImcRepository imcRepository = new ImcRepository();
        	list = imcRepository.recuperarRangoPesoDAO(min_peso, max_peso);
 
        return list;

	}

}

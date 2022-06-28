package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import bean.ImcResultado;
import bean.TipoIMC;

public class ImcRepository {
	
	private static Logger log = Logger.getLogger("mylog");
	private static final String RECUPERAR_RANGO_PESO = """
			SELECT * FROM `mibd`.`imc_resultado`
			WHERE peso >= ? and peso <= ?
			""";

	
	public List<ImcResultado> recuperarRangoPesoDAO (float min_peso, float max_peso) throws Exception
	{


        List<ImcResultado> list = null;
        Connection connection = null;
        PreparedStatement preparedStatement= null;
        ResultSet resultSet = null;

        
        try {

//             connection = Conexion.obtenerConexion();
	         connection =  Pool.getConnection();
             preparedStatement =connection.prepareStatement(RECUPERAR_RANGO_PESO);

             preparedStatement.setFloat(1, min_peso);
             preparedStatement.setFloat(2, max_peso);	             	             

             resultSet = preparedStatement.executeQuery();

             list = new ArrayList<ImcResultado>();

             while (resultSet.next()) {

                  ImcResultado imcResultado = componerResultado(resultSet);
                  list.add(imcResultado);
             }

        } catch (Exception e) {

             log.error("Error al recuperar un registro", e);
             throw e;

        } finally {
             Pool.liberarRecursos(connection, preparedStatement, resultSet);
        }         

        return list;

  
	}
	
	/**
	 * a partir de un registro, componemos el objeto
	 * @throws SQLException 
	 */
	private ImcResultado componerResultado (ResultSet resultSet) throws SQLException
	{
		ImcResultado imcResultado = null;
		
			int id = resultSet.getInt(1);
			float peso = resultSet.getFloat(2);
			float estatura = resultSet.getFloat(3);
			float imc_num = resultSet.getFloat(4);
			TipoIMC tipoIMC = TipoIMC.valueOf(resultSet.getString(5));
			String nombre = resultSet.getString(6);
			
			imcResultado = new ImcResultado(id, peso, estatura, imc_num, tipoIMC, nombre);
			
		return imcResultado;
		
	}



}

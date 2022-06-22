package ejercicio_imc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ejercicio_imc.bean.ImcResultado;
import ejercicio_imc.bean.TipoIMC;

/**
 * esta clase, va a agrupar
 * la funcionalidad de la base de datos
 * para trabajar con el ImcResultado
 * 
 * @author USUARIO
 *
 */
public class IMCDao {
	
	private static Logger log = Logger.getLogger("mylog");
	
	private static final String RECUPERAR_TODOS = "SELECT * FROM `mibd`.`imc_resultado`";
	private static final String INSERTAR_IMC_RES = """ 
			INSERT INTO `mibd`.`imc_resultado`
			(`peso`, `estatura`, `imc_num`, `imc_nom`, `nombre`) 
			VALUES 
			(?, ?, ?, ?, ?)
			""";
	
	
	public List<ImcResultado> recuperarTodos () throws Exception
	{
		List<ImcResultado> lista_imcs = null;
			
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			
			try {
				 connection = Conexion.obtenerConexion();
				 statement =  connection.createStatement();
				 resultSet = statement.executeQuery(RECUPERAR_TODOS);
				 lista_imcs = new ArrayList<ImcResultado> ();
				 ImcResultado imc_res_aux = null;
				 while (resultSet.next())
				 {
					 	imc_res_aux =	componerResultado(resultSet);		
					 	lista_imcs.add(imc_res_aux);
				 }
				
			}catch (Exception e) {
				log.error("Error en recuperarTodos ()", e);
				throw e;
			}finally {
				Conexion.liberarRecursos(connection, statement, resultSet);
			}
		
		return lista_imcs;
	}
	
	public void insertarImcResultado (ImcResultado resultado)
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
			try {
				connection = Conexion.obtenerConexion();
				preparedStatement = connection.prepareStatement(INSERTAR_IMC_RES);
				preparedStatement.setFloat(1, resultado.getPeso());
				preparedStatement.setFloat(2, resultado.getEstatura());
				preparedStatement.setFloat(3, resultado.getImc_num());
				preparedStatement.setString(4, resultado.getImc_nom().name());
				preparedStatement.setString(5, resultado.getNombre());
				
				preparedStatement.execute();
			} catch (SQLException e) {
				log.error("Error en insertarImcResultado ()", e);
			}
			finally {
				Conexion.liberarRecursos(connection, preparedStatement, null);
			}
		
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
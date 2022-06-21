package ejercicio_imc.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import ejercicio_imc.bean.ImcResultado;

/**
 * esta clase, va a agrupar
 * la funcionalidad de la base de datos
 * para trabajar con el ImcResultado
 * 
 * @author USUARIO
 *
 */
public class IMCDao {
	
	private static final String RECUPERAR_TODOS = "SELECT * FROM `mibd`.`imc_resultado`";
	private static final String INSERTAR_IMC_RES = """ 
			INSERT INTO `mibd`.`imc_resultado`
			(`peso`, `estatura`, `imc_num`, `imc_nom`, `nombre`) 
			VALUES 
			(?, ?, ?, ?, ?)
			""";
	
	
	public List<ImcResultado> recuperarTodos ()
	{
		List<ImcResultado> lista_imcs = null;
			
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			
			try {
				 connection = Conexion.obtenerConexion();
				 statement =  connection.createStatement();
				 resultSet = statement.executeQuery(RECUPERAR_TODOS);
				 while (resultSet.next())
				 {
					 //TODO Componer por cada Registro (RESULTSET) 
					 //1 OBJETO IMCRESULTADO.
					 //MAPEAMOS CADA COLUMNA CON UN ATRIBUTO DE LA CLASE
				 }
				
			}catch (Exception e) {
				// TODO: handle exception
			}finally {
				
			}
		
		return lista_imcs;
	}
	
	public void insertarImcResultado (ImcResultado resultado)
	{
		
	}

}

package ejercicio_imc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import ejercicio_imc.repository.Conexion;

public class MainBD {
	
	private static Logger log = Logger.getLogger("mylog");
	
	public static void main(String[] args) {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		//vamos a leer la versión de la base de datos
		try 
		{
			connection =  Conexion.obtenerConexion();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT VERSION()");
			while (resultSet.next())
			{
				String version = resultSet.getString(1);
				System.out.println("VERSION = " + version);
			}
			
		} catch (Exception e) {
			log.error("ERROR", e);
		}finally {
			Conexion.liberarRecursos(connection, statement, resultSet);
		}
	}

}

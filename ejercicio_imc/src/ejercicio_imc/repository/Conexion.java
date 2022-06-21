package ejercicio_imc.repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Conexion {
	
	private static final String RUTA_PROPERTIES = "db.properties";
	private static Logger log = Logger.getLogger("mylog");
	private static String cadena_conexion;
	private static String usuario;
	private static String contrasenia;
	private static String sdriver;
	
	static {
		//cargar el Dirver. Iniciar la conversación con la BD
		Properties properties = new Properties();
		
			try {
				properties.load(new FileReader(RUTA_PROPERTIES));
				sdriver = properties.getProperty("driver");
				cadena_conexion = properties.getProperty("cadena_conexion");
				usuario = properties.getProperty("usuario");
				contrasenia = properties.getProperty("password");
				Class.forName(sdriver);//cargo el driver
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("fichero de priedades no encontrado", e);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("erro al cargar el fichero de propiedades", e);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("Driver no encontrado - problema al conectar con la base datos", e);
			}
		
	}
	
	//obtenerCOnexión
	public static Connection obtenerConexion () throws SQLException
	{
		Connection connection = null;
		
			connection = DriverManager.getConnection(cadena_conexion, usuario, contrasenia);
		
		return connection;
	}
	//liberarRecursos
	
	public static void liberarRecursos (Connection connection, Statement st, ResultSet rs)
	{
		//OJO: libero de "adentro a fuera" ResultSet --> Statement --> Connection
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("error al liberar recursos", e);
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("error al liberar recursos", e);
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("error al liberar recursos", e);
			}
		}

	}

}

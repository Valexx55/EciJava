package repositorio;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import bean.ImcResultado;
import bean.Persona;
import bean.TipoIMC;
//import ejercicio_imc.repository.Conexion;
//import ejercicio_imc.repository.Conexion;

public class ImcRepository {
	
	private static Logger log = Logger.getLogger("mylog");
	
	private static final String RECUPERAR_RANGO_PESO = """
			SELECT * FROM `mibd`.`imc_resultado`
			WHERE peso >= ? and peso <= ?
			""";
	private static final String RECUPERAR_TODOS = """
			SELECT * FROM `mibd`.`imc_resultado`
			""";
	private static final String INSERTAR_PERSONA = """
			INSERT INTO personas
			(id, nombre, fecha_nac)
			VALUES
			(?, ?,?)
			""";


	private static final String INSERTAR_RESULTADO = """
			INSERT INTO imc_resultado
			(peso, estatura, imc_num, imc_nom, fecha, idpersona)
			VALUES
			(?,?,?,?,?,?)
			""";

	private static final String SELECT_EXISTE_PERSONA = """
			SELECT id FROM personas
			WHERE id = ?
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


	
	private void insertarPersona(Connection connection, Persona p) throws Exception {
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(INSERTAR_PERSONA);
			preparedStatement.setInt(1, p.getId());
			preparedStatement.setString(2, p.getNombre());
			preparedStatement.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
			preparedStatement.execute();

		} catch (Exception e) {
			// TODO: handle exception
			log.error("error en insertarPersona" , e);
			throw e;
		} finally {
			Pool.liberarRecursos(null, preparedStatement, null);
		}

	}
	
	public void registrarResultado(ImcResultado imcResultado) throws Exception {
		Connection connection = null;
		Savepoint savepoint = null;

			log.debug("registrarResultado");
			try {
	
				connection = Pool.getConnection();
				connection.setAutoCommit(false);
				Persona p = imcResultado.getPersona();
				if (!existePersona(connection, p)) {
					log.debug("la persona no existe " +p);
					insertarPersona(connection, p);
					savepoint = connection.setSavepoint();
					log.debug("persona insertada " + p);
				} else {
					log.debug("la persona existe " +p);
				}
				insertarRegistroImc(connection, imcResultado);
				log.debug("registro imc insertado " + imcResultado);
				
			} catch (Exception e) {
				log.error("error en registrarResultado" , e);
				if (savepoint!=null)
				{
					connection.rollback(savepoint);
				} else connection.rollback();
				
				throw e;
			} finally {
				connection.commit();
				Pool.liberarRecursos(connection, null, null);
			}
	}


	private void insertarRegistroImc(Connection connection, ImcResultado imcResultado) throws Exception {
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(INSERTAR_RESULTADO);
			preparedStatement.setFloat(1, imcResultado.getPeso());
			preparedStatement.setFloat(2, imcResultado.getEstatura());
			preparedStatement.setFloat(3, imcResultado.getImc_num());
			preparedStatement.setString(4, imcResultado.getImc_nom().name());
			preparedStatement.setDate(5,  new java.sql.Date(new java.util.Date().getTime()));
			preparedStatement.setInt(6, imcResultado.getPersona().getId());
			preparedStatement.execute();

		} catch (Exception e) {
			log.error("error en insertarRegistroImc" , e);
			throw e;
		} finally {
			Pool.liberarRecursos(null, preparedStatement, null);
		}

	}

	private boolean existePersona(Connection connection, Persona p) {
		boolean existe = false;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(SELECT_EXISTE_PERSONA);
			preparedStatement.setInt(1, p.getId());
			rs = preparedStatement.executeQuery();
			existe = rs.next();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			Pool.liberarRecursos(null, preparedStatement, rs);
		}

		return existe;
	}

	
	public List<ImcResultado> recuperarTodos() throws SQLException {				
		List<ImcResultado> lista_imc = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = Pool.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(RECUPERAR_TODOS);
			lista_imc=  new ArrayList<>();
			while (resultSet.next()){								
				lista_imc.add(componerResultado(resultSet));				
			}
			
		} catch (Exception e) {
			log.error("error al recuperar los imc  --> " + e);			
			throw e;
		}finally {
			Pool.liberarRecursos(connection, statement, resultSet);
		}
		
		return lista_imc;
	}

}

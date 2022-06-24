package ejercicio_imc.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;

import org.apache.log4j.Logger;

import ejercicio_imc.bean.ImcResultado;
import ejercicio_imc.bean.Persona;

/**
 * En esta clase contemplamos dos tablas: Persona e IMCResultados
 * 
 * 1 persona puede tener varios IMCResultados 1 ImcResultado será siempre de una
 * persona
 * 
 * relación 1:N
 * 
 * Además, añadimos el tratamiento de fechas con fecha nacimiento para persona y
 * fecha para IMCResultado
 * 
 * @author USUARIO
 *
 */
public class IMCDao2 {

	private static final String INSERTAR_PERSONA = """
			INSERT INTO personas
			(id, nombre, fecha_nac)
			VALUES
			(?,?,?)
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

	private static Logger log = Logger.getLogger("mylog");

	public void registrarResultado(ImcResultado imcResultado) throws Exception {
		Connection connection = null;
		Savepoint savepoint = null;

			log.debug("registrarResultado");
			try {
	
				connection = Conexion.obtenerConexion();
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
				Conexion.liberarRecursos(connection, null, null);
			}
	}

	private void insertarPersona(Connection connection, Persona p) throws Exception {
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(INSERTAR_PERSONA);
			preparedStatement.setInt(1, p.getId());
			preparedStatement.setString(2, p.getNombre());
			preparedStatement.setDate(3, new Date(p.getFecha_nac().getTime()));
			preparedStatement.execute();

		} catch (Exception e) {
			// TODO: handle exception
			log.error("error en insertarPersona" , e);
			throw e;
		} finally {
			Conexion.liberarRecursos(null, preparedStatement, null);
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
			preparedStatement.setDate(5, new Date(new java.util.Date().getTime()));
			preparedStatement.setInt(6, imcResultado.getPersona().getId());
			preparedStatement.execute();

		} catch (Exception e) {
			log.error("error en insertarRegistroImc" , e);
			throw e;
		} finally {
			Conexion.liberarRecursos(null, preparedStatement, null);
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
			Conexion.liberarRecursos(null, preparedStatement, rs);
		}

		return existe;
	}

}

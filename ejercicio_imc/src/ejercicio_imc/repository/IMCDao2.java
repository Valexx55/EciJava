package ejercicio_imc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ejercicio_imc.bean.ImcResultado;

/**
 * En esta clase contemplamos
 * dos tablas: Persona e IMCResultados
 * 
 * 1 persona puede tener varios IMCResultados
 * 1 ImcResultado será siempre de una persona
 * 
 * relación 1:N
 * 
 * Además, añadimos el tratamiento de fechas
 * con fecha nacimiento para persona
 * y fecha para IMCResultado
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
			(id, peso, estatura, imc_num, imc_nom, fecha, idpersona)
			VALUES
			(?,?,?,?,?,?,?)
			""";
	
	public void registrarResultado (ImcResultado imcResultado)
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
	}

}

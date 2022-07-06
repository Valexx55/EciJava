package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import dto.ImcResultado;
import dto.TipoIMC;

public class IMCResultadoMapper implements RowMapper<ImcResultado> {

	@Override
	public ImcResultado mapRow(ResultSet rs, int arg1) throws SQLException {
		ImcResultado imcResultado = null;
		
		int id = rs.getInt(1);
		float peso = rs.getFloat(2);
		float estatura = rs.getFloat(3);
		float imc_num = rs.getFloat(4);
		TipoIMC tipoIMC = TipoIMC.valueOf(rs.getString(5));
		Date fecha_reg = new Date ( rs.getDate(6).getTime());
		
		imcResultado = new ImcResultado(id, peso, estatura, imc_num, tipoIMC, null, fecha_reg);
		
		return imcResultado;
	}

}

package repository;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import dto.ImcResultado;


@Repository
public class IMCRepository {
	
	JdbcTemplate jdbcTemplate;
	
	private static final String RECUEPERAR_TODOS_IMC = "select * from imc_resultado";
	private static final String INSERTAR_RESULTADO = """
			INSERT INTO imc_resultado
			(peso, estatura, imc_num, imc_nom, fecha, idpersona)
			VALUES
			(?,?,?,?,?,?)
			""";
	
	@Autowired
	public IMCRepository (DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<ImcResultado> recuperarTodos ()
	{
		List<ImcResultado> lImcResultados = null;
		
			RowMapper<ImcResultado> rowMapper = new IMCResultadoMapper();
			lImcResultados = this.jdbcTemplate.query(RECUEPERAR_TODOS_IMC, rowMapper);
		
		return lImcResultados;
	}
	
	public boolean insertarIMCResultado (ImcResultado imcResultado)
	{
		boolean ok = false;
		int n_filas = -1;
		
																	//(peso, estatura, imc_num, imc_nom, fecha, idpersona)
			n_filas = this.jdbcTemplate.update(INSERTAR_RESULTADO, imcResultado.getPeso(), imcResultado.getEstatura(), imcResultado.getImc_num(), imcResultado.getImc_nom().toString(), new java.sql.Date(new Date().getTime()), 1);
			ok = (n_filas == 1);
			
			
		return ok;
	}
	
}

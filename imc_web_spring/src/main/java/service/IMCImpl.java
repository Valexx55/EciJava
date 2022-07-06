package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dto.ImcResultado;
import dto.Persona;
import dto.TipoIMC;
import repository.IMCRepository;
import service.interfaces.IMCService;

@Service
public class IMCImpl implements IMCService {
	
	@Autowired
	IMCRepository imcRepository;
	
	@Transactional
	public ImcResultado calcula (Persona persona)
	{
		ImcResultado imcResultado = null;
		
			float imc_num = persona.getPeso()/(persona.getAltura()*persona.getAltura());
			TipoIMC imc_nom = TipoIMC.traduceIMC(imc_num);
			imcResultado = new ImcResultado(persona.getPeso(), persona.getAltura(), imc_num, imc_nom, persona.getNombre());
			this.imcRepository.insertarIMCResultado(imcResultado);
			
			/**
			 * Provocamos fallo 
			 */
			/*String cad = new String("javi");
			char l = cad.charAt(4);*/
			
		return imcResultado;
	}

	@Override
	@Transactional
	public List<ImcResultado> obtenerListaIMCs() {
		List<ImcResultado> lista_imcs = null;
		
			lista_imcs = this.imcRepository.recuperarTodos();
		
		return lista_imcs;
	}

}

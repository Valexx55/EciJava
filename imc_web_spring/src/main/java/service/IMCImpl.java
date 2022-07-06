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

	@Override
	public ImcResultado calcula(Persona p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImcResultado> obtenerListaIMCs() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}

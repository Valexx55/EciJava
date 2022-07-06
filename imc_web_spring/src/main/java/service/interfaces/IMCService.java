package service.interfaces;

import java.util.List;

import dto.ImcResultado;
import dto.Persona;

public interface IMCService {

	ImcResultado calcula (Persona p);
	List<ImcResultado> obtenerListaIMCs ();
}

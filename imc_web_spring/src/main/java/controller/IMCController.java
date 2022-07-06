package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import aspectos.Chequeable;
import dto.ImcResultado;
import dto.Persona;
import service.interfaces.IMCService;

@Controller
public class IMCController {

	@Autowired
	IMCService imcservice;

	@Chequeable
	@RequestMapping("/inicio")
	public String testController() {

		return "inicio";
	}

	@RequestMapping(path = "/imc", method = RequestMethod.POST)
	public String imc(@RequestBody Persona p, Model m) {

		ImcResultado imc_res = this.imcservice.calcula(p);
		m.addAttribute("resultado", imc_res);
		return "resultado_imc";
	}
	
	@RequestMapping(path = "/listarimc", method = RequestMethod.GET)
	public String listarimc(Model m) {

		List<ImcResultado> lista_imcs = this.imcservice.obtenerListaIMCs();
		m.addAttribute("lista_imcs", lista_imcs);
		return "listado_imc";
	}
	
	@ResponseBody
	@RequestMapping(path = "/persona", method = RequestMethod.GET)
	public Persona personajson() {

		Persona p =new Persona();
		p.setNombre("Vale");
		p.setAltura(2f);
		p.setPeso(100f);
		return p;
	}

}

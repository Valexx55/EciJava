package edu.eci.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
public class JSONPController {
	
	@Autowired
	ObjectMapper om;//es para serializar a JSON el alumno
	
	@GetMapping("/jsonp/alumno")
	public void testJsonp (HttpServletRequest request, HttpServletResponse response,
			@RequestParam (value = "callback", required = true) String callback) throws IOException
	{
		ObjectNode objectNode = om.createObjectNode();//nuestro alumno
		objectNode.put("id" , 15);
		objectNode.put("nombre" , "Nacho");
		objectNode.put("apellido" , "Fdez");
		objectNode.put("email" , "nacho@rm.es");
		objectNode.put("creadoEn" , "2021-09-28");
		
		String alumno_json = objectNode.toString();
		String cuerpo_respuesta = callback + "(" + alumno_json + ");";
		
		System.out.println("Cuerpo respuesta = " + cuerpo_respuesta);
		
		response.setContentType("application/javascript;charset=UTF-8");
		response.getWriter().print(cuerpo_respuesta);
	}

}

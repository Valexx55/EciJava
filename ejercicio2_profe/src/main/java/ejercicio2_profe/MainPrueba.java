package ejercicio2_profe;

import com.google.gson.Gson;

import ejercicio1.bean.Persona;

public class MainPrueba {
	
	public static void main(String[] args) {
		Persona persona = null;
		
		persona = new Persona("Jesus", 30);
		Gson gson = new Gson();
		String persona_json = gson.toJson(persona);
		System.out.println(persona_json);
		Persona pfrom_json = gson.fromJson(persona_json, Persona.class);
		System.out.println(pfrom_json);
		
		for (String param : args)
		{
			System.out.println(param);
		} //TODO ficheros, clase misteriosa
	}

}

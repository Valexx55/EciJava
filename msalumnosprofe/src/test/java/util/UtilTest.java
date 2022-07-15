package util;

import com.google.gson.Gson;

//clase auxiliar para serializar y deserializar JSON con GSON
//para sayudarnos a componer los casos de prueba

public class UtilTest {
	
	public static String toJSON (Object object)
	{
		String json_dev = null;
		
			Gson gson = new Gson (); //DRY dont repeat yourself
			json_dev = gson.toJson(object);//serializo - de Objeto a JSON-
				
				
		return json_dev;
	}
	
	public static <T>Object toObject(String json_string, Class<T> clase) {
		Object odev = null;
		
			Gson gson = new Gson ();
			odev = gson.fromJson(json_string, clase);
		
		return odev;
		
	}

}
package ejercicio1.ficheros;

import java.io.File;

public class MainListadoFicheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 /*
		  * PRUEBA1
		  * 
		  * Crear una carpeta en la raíz de nuestro 
		 proyecto Java dentro de Eclipse e introducir 
		 algunos ficheros. Hacer después un 
		 programa, para que liste el directorio y los 
		 ficheros*/
		
		prueba1();
		
		/*
		 * PRUEBA 2 
		 * 
		 * Hacer un programa para que desde el 
directorio actual (“.”), recorra el arbol de 
directorios y muestre todos los directorios, 
subdirectorios y sus respectivos archivos
		 */
		
		prueba2();
	}
	
	private void mostrarDirectorios (String fichero) {
		
		File factual = new File(fichero);
		String [] lista = null;
		
		System.out.println(factual.getName());
		
		if (factual.isDirectory())
		{
			lista = factual.list();
			for (String cadena: lista)
			{
				mostrarDirectorios(fichero+'\\'+cadena);
			}
		}
	}
	
	public static void prueba2 ()
	{
	 new MainListadoFicheros().mostrarDirectorios (".");
	}
	
	public static void prueba1 ()
	{
		File f = new File("midir");
		if (f.exists())
		{
			System.out.println("El fichero existe");
			if (f.isDirectory())
			{
				System.out.println("Es un directorio!");
				//obtener los ficheros de dentro
				String[] lista_ficheros =  f.list();
				for (String fichero : lista_ficheros)
				{
					System.out.println(fichero);
				}
			}
		}
	}

}

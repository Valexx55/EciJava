package ejercicio1.bean;

//BEAN; JAVA BEAN; POJO 
// Un clase sencilla de Java con sus métodos de acceso 
//y el constructor

public class Persona implements Comparable<Persona>{
	
	private String nombre;
	private int edad;
	
	
	
	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}



	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}



	public String getNombre() {
		return this.nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}



	public Persona() {
		// TODO Auto-generated constructor stub
		System.out.println("En el constrcutor de persona");
	}


	//oreden natural - por nombre
	@Override
	public int compareTo(Persona o) {
		int resultado = 0;
		
			resultado = this.nombre.compareTo(o.nombre);
		
		return resultado;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		
			if (this == obj)
			{
				iguales = true;
			} else if ( !(obj instanceof Persona))
			{
				iguales = false;
			} else {
				Persona p1 = (Persona)obj;
				//si coinciden nombre y edad, de this y p1, son iguales
				iguales = (this.edad == p1.edad) && (this.nombre.equals(p1.nombre));
			}

		return iguales;
	}

}

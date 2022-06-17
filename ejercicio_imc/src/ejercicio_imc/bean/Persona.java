package ejercicio_imc.bean;

public class Persona {
	
	private int id;
	private String nombre;
	private float peso;
	private float altura;
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Persona(int id, String nombre, float peso, float altura) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.peso = peso;
		this.altura = altura;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	
	

}

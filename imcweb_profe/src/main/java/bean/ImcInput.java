package bean;

public class ImcInput {
	
	private String nombre;
	private int id;
	private float estatura;
	private float peso;
	
	public ImcInput() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ImcInput(String nombre, int id, float estatura, float peso) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.estatura = estatura;
		this.peso = peso;
	}



	@Override
	public String toString() {
		return "ImcInput [nombre=" + nombre + ", id=" + id + ", estatura=" + estatura + ", peso=" + peso + "]";
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getEstatura() {
		return estatura;
	}
	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	

}

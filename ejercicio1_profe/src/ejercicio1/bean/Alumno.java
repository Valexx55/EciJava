package ejercicio1.bean;

public class Alumno extends Persona {
	private int nota;

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public Alumno(String nombre, int edad, int nota) {
		super(nombre, edad);
		this.nota = nota;
	}

	public Alumno(String nombre, int edad) {
		super(nombre, edad);
	}

	public Alumno() {
		super();
	}

	@Override
	public String toString() {
		String str_persona = super.toString();
		str_persona = str_persona + " nota=" + nota;
		return str_persona;
	}

}

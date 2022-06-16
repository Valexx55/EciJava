package ejercicio1.bean;


public class Alumno extends Persona {

	private int nota;
	private TipoNota tipoNota;

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public Alumno(String nombre, int edad, int nota) /*throws NotaException*/ {
		super(nombre, edad);
		this.nota = nota;
		this.tipoNota = TipoNota.traduceNota(nota);
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
		
			str_persona = str_persona + " nota=" + nota + " TipoNota = " + tipoNota;

		return str_persona;
	}

}

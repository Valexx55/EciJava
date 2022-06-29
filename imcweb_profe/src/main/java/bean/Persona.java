package bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Persona {
	
	private int id;
	private String nombre;
	private float peso;
	private float altura;
	
	private Date fecha_nac;
	private List<ImcResultado> lista_imcs;
	
	
	private static int contador;
	
	
	
	public Persona(int id, String nombre, float peso, float altura, Date fecha_nac, List<ImcResultado> lista_imcs) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.peso = peso;
		this.altura = altura;
		this.fecha_nac = fecha_nac;
		this.lista_imcs = lista_imcs;
	}
	
	public Persona(int id, String nombre, float peso, float altura, Date fecha_nac) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.peso = peso;
		this.altura = altura;
		this.fecha_nac = fecha_nac;
	}


	public Date getFecha_nac() {
		return fecha_nac;
	}


	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}


	public List<ImcResultado> getLista_imcs() {
		return lista_imcs;
	}


	public void setLista_imcs(List<ImcResultado> lista_imcs) {
		this.lista_imcs = lista_imcs;
	}


	public static int getContador() {
		return contador;
	}


	public static void setContador(int contador) {
		Persona.contador = contador;
	}


	static {
		contador = 0;
	}
	
	public Persona() {
		// TODO Auto-generated constructor stub
		contador ++;
		this.id = contador;
		this.lista_imcs = new ArrayList<ImcResultado>();
	}
	
	
	public Persona(int id, String nombre, float peso, float altura) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.peso = peso;
		this.altura = altura;
		this.lista_imcs = new ArrayList<ImcResultado>();
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


	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", peso=" + peso + ", altura=" + altura + "]";
	}
	
	
	

}

package dto;

import java.util.Date;

public class ImcResultado {
	
	private int id;
	private float peso;
	private float estatura;
	private float imc_num;
	private TipoIMC imc_nom;
	
	private Persona persona;
	private Date fecha;
	
	
	
	public ImcResultado(int id, float peso, float estatura, float imc_num, TipoIMC imc_nom, Persona persona,
			Date fecha) {
		super();
		this.id = id;
		this.peso = peso;
		this.estatura = estatura;
		this.imc_num = imc_num;
		this.imc_nom = imc_nom;
		this.persona = persona;
		this.fecha = fecha;
	}


	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public ImcResultado() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ImcResultado(int id, float peso, float estatura, float imc_num, TipoIMC imc_nom, String nombre) {
		super();
		this.id = id;
		this.peso = peso;
		this.estatura = estatura;
		this.imc_num = imc_num;
		this.imc_nom = imc_nom;
		//this.nombre = nombre;
	}
	
	public ImcResultado(float peso, float estatura, float imc_num, TipoIMC imc_nom, String nombre) {
		super();
		this.peso = peso;
		this.estatura = estatura;
		this.imc_num = imc_num;
		this.imc_nom = imc_nom;
		//this.nombre = nombre;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getEstatura() {
		return estatura;
	}
	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}
	public float getImc_num() {
		return imc_num;
	}
	public void setImc_num(float imc_num) {
		this.imc_num = imc_num;
	}
	public TipoIMC getImc_nom() {
		return imc_nom;
	}
	public void setImc_nom(TipoIMC imc_nom) {
		this.imc_nom = imc_nom;
	}


	@Override
	public String toString() {
		return "ImcResultado [id=" + id + ", peso=" + peso + ", estatura=" + estatura + ", imc_num=" + imc_num
				+ ", imc_nom=" + imc_nom + "]";
	}
	
	

}
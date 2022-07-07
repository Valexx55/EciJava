package edu.eci.repository.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity//esta clase está asociada a un tabla
@Table(name = "alumnos")
public class Alumno {
	
	@Id//esta es la clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)//use el autoinc de MYSQL
	private Long id;
	
	@Column(length = 50)
	private String nombre;
	
	private String apellido;
	
	private int edad;
	
	private String email;
	
	@Column(name = "creado_en")//especificamos un nombre de columna distinto
	@Temporal(TemporalType.TIMESTAMP)//le decimos que almacene la fecha con esa precisión
	private Date creadoEn;
	
	@PrePersist//el método así anotado se ejecuta automáticamente al guardar el objeto/registro en la bd
	private void generarFechaCreacion ()
	{
		this.creadoEn = new Date();
	}
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Alumno(Long id, String nombre, String apellido, int edad, String email, Date creadoEn) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.email = email;
		this.creadoEn = creadoEn;
	}



	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", email="
				+ email + ", creadoEn=" + creadoEn + "]";
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreadoEn() {
		return creadoEn;
	}
	public void setCreadoEn(Date creadoEn) {
		this.creadoEn = creadoEn;
	}

	
}

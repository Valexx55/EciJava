package edu.eci.repository.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cursos")
public class Curso {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private String nombre;
	
	@OneToMany (fetch = FetchType.LAZY)
	private List<Alumno> alumnos;
	
	
	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	@Column(name = "creado_en")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creadoEn;
	
	@PrePersist
	public void generarFechaInsercion ()
	{
		this.creadoEn = new Date();
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

	public Date getCreadoEn() {
		return creadoEn;
	}

	public void setCreadoEn(Date creadoEn) {
		this.creadoEn = creadoEn;
	}
	
	public Curso() {
		// TODO Auto-generated constructor stub
		this.alumnos = new ArrayList<Alumno>();
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", creadoEn=" + creadoEn + "]";
	}

	public Curso(Long id, String nombre, Date creadoEn) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.creadoEn = creadoEn;
		this.alumnos = new ArrayList<Alumno>();
	}
	
	public void addALumno (Alumno alumno)
	{
		this.alumnos.add(alumno);
	}
	
	public void removeAlumno (Alumno alumno)
	{
		this.alumnos.remove(alumno);
	}

	
}
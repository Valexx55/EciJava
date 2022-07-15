package edu.eci.repository.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity // esta clase está asociada a un tabla
@Table(name = "alumnos")
@NamedStoredProcedureQueries(
		{
		@NamedStoredProcedureQuery
		(
				name = "Alumno.alumnosRegistradosHoy", 
				procedureName = "obtenerAlumnosRegistradosHoy", 
				resultClasses = edu.eci.repository.entity.Alumno.class) 
		})
public class Alumno {

	@Id // esta es la clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // use el autoinc de MYSQL
	private Long id;

	@Column(length = 50)
	@Size(min = 3, max = 15)
	private String nombre;

	@NotEmpty
	private String apellido;

	@Min(0)
	@Max(130)
	private int edad;

	@Email
	private String email;

	@Column(name = "creado_en") // especificamos un nombre de columna distinto
	@Temporal(TemporalType.TIMESTAMP) // le decimos que almacene la fecha con esa precisión
	private Date creadoEn;
	
	@Lob//large object binary - guardar un archivo en base de datos
	@JsonIgnore //así evitamos que este campo se serialice en la respuesta
	private byte[] foto;
	
	//este método genera un "indicativo"/flag
	//de modo que si el alumno tiene foto en la base de datos
	//, devovlemos algo
	//si no, null
	public Integer getFotoHashCode ()
	{
		Integer idev = null;
			
			if (this.foto!=null)
			{
				idev = this.foto.hashCode();
			}
		
		return idev;
	}

	@PrePersist // el método así anotado se ejecuta automáticamente al guardar el// objeto/registro en la bd
	private void generarFechaCreacion() {
		this.creadoEn = new Date();
	}

	public Alumno() {
		// TODO Auto-generated constructor stub
	}
	
	

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
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

	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		
			if (this == obj)
			{
				iguales = true;
			} else if (!(obj instanceof Alumno))
			{
				iguales = false;
			} else {
				Alumno alumno_aux = (Alumno) obj;
				iguales = ((this.id!=null)&&(this.id.equals(alumno_aux.id)));
			}
		
		
		return iguales;
	}
}

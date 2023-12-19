package ar.com.gugler.sgc.modelo;

import java.util.ArrayList;

import java.util.Objects;

public abstract class Asignatura extends BaseModelo {
//	Atributos
	private Integer codigo; 
	private String nombre;
	private ArrayList<Alumno> alumnos;
	private Profesor profesor;
//	constructor
	public Asignatura(Integer codigo, String nombre, Profesor profesor) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.alumnos = new ArrayList<Alumno>();
		this.profesor = profesor;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	@Override
	public String toString() {
		return "Asignatura [codigo=" + codigo + ", nombre=" + nombre + ", alumnos=" + alumnos + ", profesor=" + profesor
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(alumnos, codigo, nombre, profesor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		return Objects.equals(alumnos, other.alumnos) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(profesor, other.profesor);
	}
	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	
	

}

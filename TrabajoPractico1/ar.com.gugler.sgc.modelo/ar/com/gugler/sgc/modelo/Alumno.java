package ar.com.gugler.sgc.modelo;

import java.time.LocalDate;

import java.util.Objects;

public class Alumno extends Persona{
//	atributos
	private String legajo;
//	constructor
	public Alumno(String numeroDocumento, String apellido, String nombres, LocalDate fechaNacimiento, String domicilio,
		String telefono, String email, String legajo) {
		super(numeroDocumento, apellido, nombres, fechaNacimiento, domicilio, telefono, email);
		this.legajo = legajo;
}
	
	
	@Override
	public String mostrarInformacion() {
		return super.toString() + this.toString();
	}
	
//	getter setter
	
	public String getLegajo() {
		return legajo;
	}


	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
//	equals's tostring


	@Override
	public String toString() {
		return "legajo=" + legajo + "";
	}


	@Override
	public int hashCode() {
		return Objects.hash(legajo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(legajo, other.legajo);
	}

	


	
	
	
}
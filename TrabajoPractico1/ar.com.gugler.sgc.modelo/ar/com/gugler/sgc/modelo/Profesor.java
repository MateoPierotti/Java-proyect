package ar.com.gugler.sgc.modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Profesor extends Persona{
//	atributos
	private String cuil;
	private LocalDate fechaIngreso;
//	constructor
	public Profesor(String numeroDocumento, String apellido, String nombres, LocalDate fechaNacimiento, String domicilio,
		String telefono, String email, String cuil, LocalDate fechaIngreso) {
		super(numeroDocumento, apellido, nombres, fechaNacimiento, domicilio, telefono, email);
		this.cuil = cuil;
		this.fechaIngreso = fechaIngreso;
}
	
	@Override
	public String mostrarInformacion() {
		// TODO Auto-generated method stub
		return super.toString() + this.toString();
	}
//	getter setter
	@Override
	public String toString() {
		return " [cuil=" + cuil + ", fechaIngreso=" + fechaIngreso + "]";
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuit(String cuil) {
		this.cuil = cuil;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
//	equals's tostring



	@Override
	public int hashCode() {
		return Objects.hash(cuil, fechaIngreso);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		return Objects.equals(cuil, other.cuil) && Objects.equals(fechaIngreso, other.fechaIngreso);
	}
	
	
	
	
	
}

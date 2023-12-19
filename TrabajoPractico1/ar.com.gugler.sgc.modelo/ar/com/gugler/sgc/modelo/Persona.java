package ar.com.gugler.sgc.modelo;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Persona extends BaseModelo{
//	atributos
	private String numeroDocumento;
	private String apellido;
	private String nombres;
	private LocalDate fechaNacimiento;
	private String domicilio;
	private String telefono;
	private String email;
//	contructor

//	metodo abstracto
	public abstract String mostrarInformacion();
	
	
	public Persona(String numeroDocumento, String apellido, String nombres, LocalDate fechaNacimiento, String domicilio,
		String telefono, String email) {
	super();
	this.numeroDocumento = numeroDocumento;
	this.apellido = apellido;
	this.nombres = nombres;
	this.fechaNacimiento = fechaNacimiento;
	this.domicilio = domicilio;
	this.telefono = telefono;
	this.email = email;
}


	@Override
	public String toString() {
		return " numeroDocumento=" + numeroDocumento + ", apellido=" + apellido + ", nombres=" + nombres
				+ ", fechaNacimiento=" + fechaNacimiento + ", domicilio=" + domicilio + ", telefono=" + telefono
				+ ", email=" + email + "";
	}
	
	
	
	
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(apellido, domicilio, email, fechaNacimiento, nombres, numeroDocumento, telefono);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(domicilio, other.domicilio)
				&& Objects.equals(email, other.email) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(nombres, other.nombres) && Objects.equals(numeroDocumento, other.numeroDocumento)
				&& Objects.equals(telefono, other.telefono);
	}
	
	
	
}

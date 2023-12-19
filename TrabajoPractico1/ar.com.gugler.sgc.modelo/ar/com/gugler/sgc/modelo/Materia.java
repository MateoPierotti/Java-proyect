package ar.com.gugler.sgc.modelo;

import java.util.Objects;

public class Materia extends Asignatura{

	private int anio;

	public Materia(Integer codigo, String nombre, Profesor profesor, int anio) {
		super(codigo, nombre, profesor);
		this.anio = anio;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	@Override
	public String toString() {
		return "Materia [anio=" + anio + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(anio);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materia other = (Materia) obj;
		return anio == other.anio;
	}
	
	
}

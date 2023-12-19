package ar.com.gugler.sgc.modelo;


import java.util.Objects;

public class Curso extends Asignatura implements Administrable{
	
	private int cupo;

	public Curso(Integer codigo, String nombre, Profesor profesor, int cupo) {
		super(codigo, nombre, profesor);
		this.cupo = cupo;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	@Override
	public String toString() {
		return "Curso [cupo=" + cupo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cupo);
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
		Curso other = (Curso) obj;
		return cupo == other.cupo;
	}
	
//	metodos agregar y eliminar
	public void agregarAlumno(Alumno alum){
		getAlumnos().add(alum);
	}
	public void eliminarAlumno(Alumno alum){
		getAlumnos().remove(alum);
	}

	@Override
	public boolean admiteInscripciones() {
		return getAlumnos().size()>25;
	}
}

package ar.com.gugler.sgc.modelo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.com.gugler.sgc.dao.AlumnoDAO;
import ar.com.gugler.sgc.dao.MateriaDAO;
import ar.com.gugler.sgc.dao.ProfesorDAO;
public class TPFinal1 {

	public static void main(String[] args) throws SQLException {
		
		LocalDate fechaEjemplo = LocalDate.of(1984, 2, 16);
		LocalDate fechaIngreso = LocalDate.of(2002, 8, 16);
		Alumno alum1 = new Alumno("94344846", "Pierotti", "Mateo", fechaEjemplo, "Concepcion del Uruguay", "3442 466787", "mateopierotti@gmail.com", "Buenas calificaciones");
		Alumno alum2 = new Alumno("098764543", "Del Potro", "Juan", fechaEjemplo, "Concepcion del Uruguay", "1234 567234", "JuanMartin@gmail.com", "buenas calificaciones");
		Profesor profe1 = new Profesor("0987654", "Matias", "Pierotti", fechaEjemplo, "Concepcion del Uruguar", "3442466706", "mateopierotti@gmail.com", "12699", fechaIngreso);
	
		Curso programacionEnJava = new Curso(123, "Programacion En Java", profe1, 24);
		programacionEnJava.agregarAlumno(alum1);
		programacionEnJava.agregarAlumno(alum2);
//		var datos = Universidad.mostrarDatos(alum1);
//		alum1.mostrarInformacion();
//		System.out.print(datos);
		Materia matematica = new Materia(233, "Matematica", profe1, 2024);
		
//		ProfesorDAO.createTable();
//		ProfesorDAO dao = new ProfesorDAO();
//		dao.insert(profe1);
//		
//		List<Profesor>	profes = dao.getAll();
//		
//		for (Profesor profesor : profes) {
//			System.out.println(profesor.mostrarInformacion());
//		}
		
//		AlumnoDAO.createTable();
//		AlumnoDAO dao1 = new AlumnoDAO();
//		dao1.insert(alum2);
//		
//		List<Alumno> alumnos = dao1.getAll();
//		
//		for (Alumno alumn : alumnos) {
//			System.out.println(alumn.mostrarInformacion());
//		}
		
		MateriaDAO.createTable();
		MateriaDAO dao2 = new MateriaDAO();
		dao2.insert(matematica);
		
		List<Materia> mate = dao2.getAll();
		
		for (Materia mater : mate) {
			System.out.println(mater.toString());
		}
	}

}

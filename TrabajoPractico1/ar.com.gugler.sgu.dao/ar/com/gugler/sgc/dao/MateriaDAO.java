/**
 * 
 */
package ar.com.gugler.sgc.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import ar.com.gugler.sgc.modelo.Alumno;
import ar.com.gugler.sgc.modelo.Materia;
import ar.com.gugler.sgc.modelo.Profesor;

/**
 * @author mateopierotti
 *
 */
public class MateriaDAO extends GenericDAO<Materia> {

	@Override
	public String getTable() {
		return "MATERIA";
	}

	@Override
	protected String getInsertSql() {
		return "insert into MATERIA (codigo, nombre, alumnos, profesor, anio) "
				+ "values (?, ?, ?, ?, ?) ";
	}

	@Override
	protected void setValuesInsert(PreparedStatement preparedStatement, Materia object) throws SQLException {

		preparedStatement.setInt(1, object.getCodigo());
		preparedStatement.setString(2, object.getNombre());
		preparedStatement.setString(3, object.getAlumnos().toString());
		preparedStatement.setString(4, object.getProfesor().getNombres());
		preparedStatement.setInt(5, object.getAnio());
	}

	@Override
	protected String getUpdateSql() {
		return "update ALUMNO, numeroDocumento = ?, apellido = ?, "
				+ "nombre = ?, domicilio = ?, telefono = ?, "
				+ "email = ?, fechaNacimiento = ? legajo = ?, "
				+ "where id = ? ";
	}

	@Override
	protected void setValuesUpdate(PreparedStatement preparedStatement, Materia object) throws SQLException {
		preparedStatement.setInt(1, object.getCodigo());
		preparedStatement.setString(2, object.getNombre());
		preparedStatement.setObject(3, object.getAlumnos());
		preparedStatement.setObject(4, object.getProfesor());
		preparedStatement.setInt(5, object.getAnio());
		preparedStatement.setLong(6, object.getId());
	}
	

	@Override
	protected Materia populate(ResultSet rs) throws SQLException {
		Long id = rs.getLong(1);
		Integer codigo = rs.getInt(2);
		String nombre = rs.getString(3);
		ArrayList<Alumno> alumnos = (ArrayList<Alumno>) rs.getObject(4);
		Profesor profesor = (Profesor) rs.getObject(5);
		int anio = rs.getInt(6);
		
		Materia p = new Materia(codigo, nombre, profesor, anio);
		p.setId(id);
		return p;
	}
	
	public static void createTable() throws SQLException {
		Statement st = Connection.getInstance().getConnection().createStatement();
		st.execute("CREATE TABLE IF NOT EXISTS MATERIA ("
				+ "id int NOT NULL AUTO_INCREMENT, "
				+ "codigo int NOT NULL, "
				+ "nombre text NOT NULL, "
				+ "alumnos text NOT NULL, "
				+ "profesor text NOT NULL, "
				+ "anio text , "
				+ " PRIMARY KEY (id))");
		st.close();
	}

}

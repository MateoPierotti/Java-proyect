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

import ar.com.gugler.sgc.modelo.Alumno;

/**
 * @author mateopierotti
 *
 */
public class AlumnoDAO extends GenericDAO<Alumno> {

	@Override
	public String getTable() {
		return "ALUMNO";
	}

	@Override
	protected String getInsertSql() {
		return "insert into ALUMNO (numeroDocumento, apellido, nombre, domicilio, telefono, email, fechaNacimiento, legajo) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?) ";
	}

	@Override
	protected void setValuesInsert(PreparedStatement preparedStatement, Alumno object) throws SQLException {

		preparedStatement.setString(1, object.getNumeroDocumento());
		preparedStatement.setString(2, object.getApellido());
		preparedStatement.setString(3, object.getNombres());
		preparedStatement.setString(4, object.getDomicilio());
		preparedStatement.setString(5, object.getTelefono());
		preparedStatement.setString(6, object.getEmail());
		preparedStatement.setDate(7, Date.valueOf(object.getFechaNacimiento()));
		preparedStatement.setString(8, object.getLegajo());
	}

	@Override
	protected String getUpdateSql() {
		return "update ALUMNO, numeroDocumento = ?, apellido = ?, "
				+ "nombre = ?, domicilio = ?, telefono = ?, "
				+ "email = ?, fechaNacimiento = ? legajo = ?, "
				+ "where id = ? ";
	}

	@Override
	protected void setValuesUpdate(PreparedStatement preparedStatement, Alumno object) throws SQLException {
		preparedStatement.setString(1, object.getNumeroDocumento());
		preparedStatement.setString(2, object.getApellido());
		preparedStatement.setString(3, object.getNombres());
		preparedStatement.setString(4, object.getDomicilio());
		preparedStatement.setString(5, object.getTelefono());
		preparedStatement.setString(6, object.getEmail());
		preparedStatement.setDate(7, Date.valueOf(object.getFechaNacimiento()));
		preparedStatement.setString(8, object.getLegajo());
		preparedStatement.setLong(9, object.getId());
	}
	

	@Override
	protected Alumno populate(ResultSet rs) throws SQLException {
		Long id = rs.getLong(1);
		String numeroDocumento = rs.getString(2);
		String apellido = rs.getString(3);
		String nombre = rs.getString(4);
		String domicilio = rs.getString(5);
		String telefono = rs.getString(6);
		String email = rs.getString(7);
		LocalDate fechaNacimiento = rs.getDate(8).toLocalDate();
		String legajo = rs.getString(9);
		Alumno p = new Alumno(numeroDocumento, apellido, nombre, fechaNacimiento, domicilio, telefono, email, legajo);
		p.setId(id);
		return p;
	}
	
	public static void createTable() throws SQLException {
		Statement st = Connection.getInstance().getConnection().createStatement();
		st.execute("CREATE TABLE IF NOT EXISTS ALUMNO ("
				+ "id int NOT NULL AUTO_INCREMENT, "
				+ "numeroDocumento text NOT NULL, "
				+ "apellido text NOT NULL, "
				+ "nombre text NOT NULL, "
				+ "domicilio text , "
				+ "telefono text , "
				+ "email text , "
				+ "fechaNacimiento date , "
				+ "legajo text ,"
				+ " PRIMARY KEY (id))");
		st.close();
	}

}

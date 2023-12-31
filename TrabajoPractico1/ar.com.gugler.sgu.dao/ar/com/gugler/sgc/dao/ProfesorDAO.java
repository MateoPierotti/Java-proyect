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

import ar.com.gugler.sgc.modelo.Profesor;

/**
 * @author mateopierotti
 *
 */
public class ProfesorDAO extends GenericDAO<Profesor> {

	@Override
	public String getTable() {
		return "PROFESOR";
	}

	@Override
	protected String getInsertSql() {
		return "insert into PROFESOR (cuil, numeroDocumento, apellido, nombre, domicilio, telefono, email, fechaNacimiento, fechaIngreso) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
	}

	@Override
	protected void setValuesInsert(PreparedStatement preparedStatement, Profesor object) throws SQLException {
		preparedStatement.setString(1, object.getCuil());
		preparedStatement.setString(2, object.getNumeroDocumento());
		preparedStatement.setString(3, object.getApellido());
		preparedStatement.setString(4, object.getNombres());
		preparedStatement.setString(5, object.getDomicilio());
		preparedStatement.setString(6, object.getTelefono());
		preparedStatement.setString(7, object.getEmail());
		preparedStatement.setDate(8, Date.valueOf(object.getFechaNacimiento()));
		preparedStatement.setDate(9, Date.valueOf(object.getFechaIngreso()));
	}

	@Override
	protected String getUpdateSql() {
		return "update PROFESOR set cuil = ?, numeroDocumento = ?, apellido = ?, "
				+ "nombre = ?, domicilio = ?, telefono = ?, "
				+ "email = ?, fechaNacimiento = ?, fechaIngreso = ? "
				+ "where id = ? ";
	}

	@Override
	protected void setValuesUpdate(PreparedStatement preparedStatement, Profesor object) throws SQLException {
		preparedStatement.setString(1, object.getCuil());
		preparedStatement.setString(2, object.getNumeroDocumento());
		preparedStatement.setString(3, object.getApellido());
		preparedStatement.setString(4, object.getNombres());
		preparedStatement.setString(5, object.getDomicilio());
		preparedStatement.setString(6, object.getTelefono());
		preparedStatement.setString(7, object.getEmail());
		preparedStatement.setDate(8, Date.valueOf(object.getFechaNacimiento()));
		preparedStatement.setDate(9, Date.valueOf(object.getFechaIngreso()));
		preparedStatement.setLong(10, object.getId());
	}
	

	@Override
	protected Profesor populate(ResultSet rs) throws SQLException {
		Long id = rs.getLong(1);
		String cuil = rs.getString(2);
		String numeroDocumento = rs.getString(3);
		String apellido = rs.getString(4);
		String nombre = rs.getString(5);
		String domicilio = rs.getString(6);
		String telefono = rs.getString(7);
		String email = rs.getString(8);
		LocalDate fechaNacimiento = rs.getDate(9).toLocalDate();
		LocalDate fechaIngreso = rs.getDate(10).toLocalDate();
		Profesor p = new Profesor(numeroDocumento, apellido, nombre, fechaNacimiento, domicilio, telefono, email, cuil, fechaIngreso);
		p.setId(id);
		return p;
	}
	
	public static void createTable() throws SQLException {
		Statement st = Connection.getInstance().getConnection().createStatement();
		st.execute("CREATE TABLE IF NOT EXISTS PROFESOR ("
				+ "id int NOT NULL AUTO_INCREMENT, "
				+ "cuil text NOT NULL, "
				+ "numeroDocumento text NOT NULL, "
				+ "apellido text NOT NULL, "
				+ "nombre text NOT NULL, "
				+ "domicilio text , "
				+ "telefono text , "
				+ "email text , "
				+ "fechaNacimiento date , "
				+ "fechaIngreso date ,"
				+ " PRIMARY KEY (id))");
		st.close();
	}

}

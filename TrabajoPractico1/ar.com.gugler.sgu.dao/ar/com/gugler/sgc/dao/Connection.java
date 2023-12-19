package ar.com.gugler.sgc.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

	private static Connection instance;
	private java.sql.Connection con;
	
	private Connection() {
		String url = "jdbc:h2:~/testTp2";
		try {
			Class.forName("org.h2.Driver").newInstance();
			this.con = DriverManager.getConnection(url,"sa","");
		} catch (SQLException |  InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getInstance(){
		if (instance == null) {
			instance = new Connection();
		}
		return instance;
	}
	
	
	public java.sql.Connection getConnection() {
		return this.con;
	}
}

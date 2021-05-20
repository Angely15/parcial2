package co.parcial.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Conexion {
	private Connection con = null;
	private static Conexion db;
	private PreparedStatement preparedstament;

	private static final String url = "jdbc:postgresql://queenie.db.elephantsql.com/";
	private static final String dbName = "mnjgxshj";
	private static final String driver = "org.postgresql.Driver";
	private static final String userName = "mnjgxshj";
	private static final String password = "Uzjqo00sxV0W9OzPEB1q3wpoVvGMbbUV";

	public Conexion() {
		try {
			Class.forName("con.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url + dbName, userName, password);
			System.out.print("vamos bien");
		} catch (InstantiationException |IllegalAccessException |ClassNotFoundException | SQLException e) {
			System.out.print("error");
			e.printStackTrace();
		}catch (Exception e) {
			System.out.print("error");
			e.printStackTrace();
		}

	}

	public void cerrarConexion() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Conexion getConexion() {
		if (db==null) {
			db = new Conexion();
		}
		return db;
	}
	
	public ResultSet query() throws SQLException {
		ResultSet res = preparedstament.executeQuery();
		return res;
	}

	public int execute() throws SQLException {
		int result = preparedstament.executeUpdate();
		return result;
	}

	public Connection getCon() {
		return this.con;
	}

	public PreparedStatement setpreparedStatement(String sql) throws SQLException {
		this.preparedstament = con.prepareStatement(sql);
		return this.preparedstament;
	}
}

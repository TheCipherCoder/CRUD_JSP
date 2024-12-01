package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDAO {
	private static final String url = "jdbc:mysql://localhost:3306/dbsur";
	private static final String username = "root";
	private static final String	password = "27182";
	
	public static Connection obtenerConexion() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("Error al conectarnos");
		}
		
		return con;
	}
	
	public static void cerrarConexion(Connection con) {
		try {
			if(con!= null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

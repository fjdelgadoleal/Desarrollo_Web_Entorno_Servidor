package es.iessoterohernandez.daw.dwes.accesobbdd_singleton_dao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	private static Connection con = null;
	private static final String conUrl = "jdbc:mariadb://localhost:3306/classicmodels?user=root&password=root"
			+ "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//	private static final String conUrl = "jdbc:mysql://localhost:3306/classicmodels?user=root&password=root";

	public static Connection getConnection() {

		try {

			if (con == null) {
				con = DriverManager.getConnection(ConexionBD.conUrl);

				System.out.println("Conexi�n realizada correctamente");
			}

		} catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		
		return con;
	}
	
	public static void close() {
		try {
			if (con != null) con.close();
		} catch (SQLException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}

}

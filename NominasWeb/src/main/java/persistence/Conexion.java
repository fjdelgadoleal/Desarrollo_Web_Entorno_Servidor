package persistence;

import java.sql.Connection;
import java.sql.SQLException;
 
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
  
public class Conexion {
 private static BasicDataSource dataSource = null;
 
 private static DataSource getDataSource() {
  if (dataSource == null) {
   dataSource = new BasicDataSource();
   dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
   dataSource.setUsername("root");
   dataSource.setPassword("root");
   dataSource.setUrl("jdbc:mysql://localhost:3306/nominas?useTimezone=true&serverTimezone=UTC");
   dataSource.setInitialSize(20);
   dataSource.setMaxIdle(15);
   dataSource.setMaxTotal(20);
   dataSource.setMaxWaitMillis(5000);
  }
  return dataSource;
 }
 
 public static Connection conectar() {
	 try {
		 return getDataSource().getConnection();
	 }catch(SQLException e) {
       System.out.println("Error al conectar a la BD");
       return null;
   }
 }
//import java.sql.*;
//
//public class Conexion {
//	
//	public static String url = "jdbc:oracle:thin:@localhost:1521/xe";
//	public static String user = "ALEJANDRO";
//	public static String pass = "ALEJANDRO1";
//	public static Connection conn;
//	
//	public void desconectar() {
//		try {
//            if (conn != null)
//                conn.close();
//        } catch(SQLException e) {
//            System.out.println("Error al cerrar la BD");
//        }
//	}
//	
//	public static Connection conectar() {
//		try {
//            conn = DriverManager.getConnection(url,user,pass);
////            System.out.print("Conexión válida: " + conn.isValid(10));
////            System.out.println(", Estado del autocommit: " + conn.getAutoCommit());
//        } catch(SQLException e) {
//            System.out.println("Error al conectar a la BD");
//        }
//		
//		return conn;
//	}
}
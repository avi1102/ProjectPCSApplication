package config;

import java.sql.*;


public class JDBCConnection {
	static String url="jdbc:mysql://localhost:3306/pcsdb";
	static String username="root";
	static String password="niit@123";
	static Connection conn=null;
	public static Connection getDBConnection() {
		try{
			// Driver Registration by Class 
			Class.forName("com.mysql.jdbc.Driver"); // Loading Driver
			// Driver Manager Method:
			// DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn=DriverManager.getConnection(url, username, password);
			
		}
		catch(ClassNotFoundException ex) {
			System.out.println(ex);
		}
		catch(SQLException ex) {
			System.out.println(ex);
		}
		return conn;
	}

}

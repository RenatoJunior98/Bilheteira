package application.view;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class DBConnector {

	private static final String URL = "jdbc:mysql://remotemysql.com:3306/54tXwN8Pvu";
	private static final String PASS = "admin";
	private static final String USER = "admin";

	
	public static Connection getConnection() {
			try {
			 return DriverManager.
			 getConnection(URL,USER,PASS);
			 } 
			 catch (SQLException e) {
			 e.printStackTrace();
			 }
			 return null;
			 }
}

	


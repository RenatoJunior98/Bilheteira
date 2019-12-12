package bilheteira.models.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class DBConnector {
	private static final String URL = "jdbc:mysql://remotemysql.com:3306/L9FtIuPsK3?useSSL=false";
	private static final String USER = "L9FtIuPsK3";
	private static final String PASS = "xLKYqGEO40";

	private static Connection connector;
	private DBConnector () {}
	
	public static Connection getConnection() {
			try {
				if (connector == null || 
						connector.isClosed())
					connector = DriverManager.getConnection(URL,USER,PASS);
				return connector;
			 } 
			 catch (SQLException e) {
			 e.printStackTrace();
			 }
			 return null;
			 }
}

	


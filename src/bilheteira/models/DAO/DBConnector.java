package bilheteira.models.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class DBConnector {
	private static final String URL = "jdbc:mysql://remotemysql.com:3306/yZAkJiaHXd?useSSL=false";
	private static final String USER = "yZAkJiaHXd";
	private static final String PASS = "hE3SXhzEza";

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

	


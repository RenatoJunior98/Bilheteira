package bilheteira.models.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class DBConnector {
	private static final String URL = "jdbc:mysql://remotemysql.com:3306/G9rCfBmbbN?useSSL=false";
	private static final String USER = "G9rCfBmbbN";
	private static final String PASS = "sg9cqw6noQ";

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

	


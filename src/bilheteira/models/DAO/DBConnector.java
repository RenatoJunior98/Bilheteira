package bilheteira.models.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta classe �  respons�vel pela conex�o/liga��o entre o java e a base de dados
 * Contem os dados do remote sql ( base de dados ) : URL, USER, PASS
 * @author Ricardo Cruz
 *
 */
public final class DBConnector {
	private static final String URL = "jdbc:mysql://remotemysql.com:3306/L9FtIuPsK3?useSSL=false";
	private static final String USER = "L9FtIuPsK3";
	private static final String PASS = "xLKYqGEO40";

	private static Connection connector;
	private DBConnector () {}
	
	/**
	 * Este metodo � chamado sempre que for necess�rio fazer a liga��o entre base de dados e java
	 * @return da conex�o
	 */
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

	


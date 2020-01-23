package bilheteira.models.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RefundTicketDAO é uma classe de ligação entre o java e a base de dados; É
 * dedicada a guardar na base de dados a informacao que um bilhete foi devolvido
 * 
 * @author TheRenas
 *
 */

public class RefundTicketDAO {

	/**
	 * Metodo refundTicket recebe o id de um bilhete e atualiza a sua informacao na
	 * base de dados, com a informacao que foi devolvido
	 * 
	 * @param codigoBilhete : Codigo do Bilhete
	 */

	public static void refundTicket(int codigoBilhete) {
		Connection conn = DBConnector.getConnection();
		PreparedStatement stats = null;
		try {
			stats = conn.prepareStatement("UPDATE bilhete " + "SET isDevolvido = 1 " + "WHERE codigoBilhete = ?;");
			stats.setInt(1, codigoBilhete);
			stats.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo getPreco recebe o id de um bilhete e devolve o seu preço
	 * 
	 * @param codigoBilhete : Codigo do Bilhete
	 * 
	 */

	public static double getPreco(int codigoBilhete) {
		double preco = 0;
		Connection conn = DBConnector.getConnection();
		try (java.sql.PreparedStatement stats = conn.prepareStatement("select (taxa * precoBase) from "
				+ "	                      zona inner join evento_zona ON zonaID = zonaID_ev_zon inner join evento ON "
				+ "	                      eventoID = eventoID_ev_zon inner join bilhete on eventoZonaID_bilhete = eventoZonaID "
				+ "                          where codigoBilhete = ?;")) {

			stats.setInt(1, codigoBilhete);
			ResultSet rs = stats.executeQuery();
			if (rs.next()) {
				preco = rs.getDouble(1);
			}
			return preco;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
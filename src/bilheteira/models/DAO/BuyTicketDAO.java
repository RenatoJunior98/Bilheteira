package bilheteira.models.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * BuyTicketDAO � uma classe de liga��o entre a base de dados e o java; 
 * � dedicada a criar e guardar na base de dados um novo bilhete quando este � comprado; 
 * Contem o construtor da classe que recebe um idEvento e um zonaID, e
 * introduz esses atributos do bilhete na base de dados, contem a string sql com
 * a query em sql para os introduzir Faz a conex�o � base de dados a partir do
 * metodo getConnection da classe DBConnector
 * 
 * @author Renato J�nior
 *
 */
public class BuyTicketDAO {
	public static void saveBilhete(int idEvento, int zonaID, int nBilhetes) {
		String sql = "Insert into bilhete (entrada, eventoZonaID_bilhete) values (?,?)";
		int eventoZonaID = 0;
		Connection conn = DBConnector.getConnection();
		try (PreparedStatement stat = conn.prepareStatement(
				"select eventoZonaID from evento_zona where " + "eventoID_ev_zon = ? and zonaID_ev_zon = ?")) {
			stat.setInt(1, idEvento);
			stat.setInt(2, zonaID);
			try (ResultSet rs = stat.executeQuery()) {
				while (rs.next()) {
					eventoZonaID = rs.getInt("eventoZonaID");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (int i=0 ; i<nBilhetes ; i++) {
		try (PreparedStatement stat = conn.prepareStatement(sql)) {
			stat.setBoolean(1, false);
			stat.setInt(2, eventoZonaID);
			stat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Fail");
			e.printStackTrace();
		}

		}
	}
	/*public void getBilhetes() {
		String sql = "select lugaresTotalZona - count(eventoZonaID_bilhete) as \"Lugares Disponiveis\" from ((bilhete inner join evento_zona ON bilhete.eventoZonaID_bilhete=evento_zona.zonaID_ev_zon) inner join zona ON zona.zonaID=evento_zona.zonaID_ev_zon ) where eventoZonaID_bilhete = ?"
	}*/
}

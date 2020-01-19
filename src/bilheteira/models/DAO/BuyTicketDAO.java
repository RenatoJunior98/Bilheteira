package bilheteira.models.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.EventObject;

import bilheteira.models.Event;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * BuyTicketDAO é uma classe de ligação entre a base de dados e o java; 
 * É dedicada a criar e guardar na base de dados um novo bilhete quando este é comprado; 
 * Contem o construtor da classe que recebe um idEvento e um zonaID, e
 * introduz esses atributos do bilhete na base de dados, contem a string sql com
 * a query em sql para os introduzir Faz a conexão à base de dados a partir do
 * metodo getConnection da classe DBConnector
 * 
 * @author Renato Júnior
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
	
	public static ObservableList<Integer> getZonasDisponiveis(int idEvento){
		//boolean isIndisponivel = false;
		Connection conn = DBConnector.getConnection();
		ObservableList<Integer> zonasDisponiveis = FXCollections.observableArrayList();
		String sql = "SELECT zonaID, isIndisponivel from zona inner join evento_zona on zonaID = zonaID_ev_zon WHERE eventoId_ev_zon = ?";
		try (PreparedStatement stat = conn.prepareStatement(sql)) {
			stat.setInt(1,idEvento);
			try (ResultSet rs = stat.executeQuery()) {
				while (rs.next()) {
					if (BuyTicketDAO.getLugaresDisponiveis(idEvento, rs.getInt("zonaID")) > 0 && rs.getBoolean("isIndisponivel")==false)
					zonasDisponiveis.add(rs.getInt("zonaID"));
					else
						zonasDisponiveis.add(0);
				}
			}
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
			return zonasDisponiveis;
	    
	}

	
	
	public static int getLugaresDisponiveis(int eventoID, int zonaID) {
		Connection conn = DBConnector.getConnection();
		//ObservableList<Integer> lugares = FXCollections.observableArrayList();
		//ObservableList<Integer> zonas = FXCollections.observableArrayList();
		int lugaresDisponiveis = 0;
		//zonas.addAll(BuyTicketDAO.getZonasDisponiveis(eventoID));
		String sql ="SELECT (lugaresTotalZona - count(codigoBilhete)) as 'lugares' from zona\r\n" + 
				"				left join evento_zona ON zonaID_ev_zon = zonaID\r\n" + 
				"				left join bilhete ON eventoZonaID = eventoZonaID_bilhete\r\n" + 
				"				where eventoID_ev_zon = ? and zonaID_ev_zon = ?" ;
		String sql2 = "select isIndisponivel from evento_zona where eventoID_ev_zon = ? and zonaID_ev_zon = ?";
		try (PreparedStatement stat = conn.prepareStatement(sql)) {
			stat.setInt(1,eventoID);
			stat.setInt(2, zonaID);
			ResultSet rs = stat.executeQuery();
				while (rs.next()) {				
					lugaresDisponiveis = rs.getInt("lugares");
			}
				PreparedStatement stats = conn.prepareStatement(sql2);
				stats.setInt(1,eventoID);
				stats.setInt(2, zonaID);
				ResultSet rs2 = stats.executeQuery();
				while (rs2.next()) {
				if (rs2.getInt("isIndisponivel") == 1)
					lugaresDisponiveis = 0;
		}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
			return lugaresDisponiveis;
	}
}
	
	
	
	
	/*	public static int getLugaresDisponiveis(int zonaID) {
		Connection conn = DBConnector.getConnection();
		String sql = "SELECT lugaresTotalZona - count(eventoZonaID_bilhete) AS \"Lugares Disponiveis\" "
				+ "FROM ((bilhete inner join evento_zona ON bilhete.eventoZonaID_bilhete=evento_zona.zonaID_ev_zon)"
				+ " inner join zona ON zona.zonaID=evento_zona.zonaID_ev_zon ) where zona.zonaID = ?";
		
		try (PreparedStatement stat = conn.prepareStatement(sql)) {
			stat.setInt(1,zonaID);
			
			try (ResultSet rs = stat.executeQuery()) {
				if (rs.next()) {
					int lugares = rs.getInt(1);
					System.out.println("ZONA: "+zonaID + " LUGARES: "+lugares);
					return lugares;	
				}
			}
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	return 0;
	}
} */

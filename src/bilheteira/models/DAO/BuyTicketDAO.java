package bilheteira.models.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * BuyTicketDAO é uma classe de ligação entre a base de dados e o java; É
 * dedicada a criar e guardar na base de dados um novo bilhete quando este é
 * comprado; Contem o construtor da classe que recebe um idEvento e um zonaID, e
 * introduz esses atributos do bilhete na base de dados, contem a string sql com
 * a query em sql para os introduzir Faz a conexão à base de dados a partir do
 * metodo getConnection da classe DBConnector
 * 
 * @author Renato Júnior
 *
 */
public class BuyTicketDAO {
	public static ObservableList<Integer> saveBilhete(int idEvento, int zonaID, int nBilhetes, int userID) {
		ObservableList<Integer> codigosBilhetes = FXCollections.observableArrayList();
		String sql = "Insert into bilhete (entrada, userID_bilhete, eventoZonaID_bilhete) values (?,?,?)";
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

		for (int i = 0; i < nBilhetes; i++) {
			try (PreparedStatement stat = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				stat.setBoolean(1, false);
				stat.setInt(2, userID);
				stat.setInt(3, eventoZonaID);
				stat.executeUpdate();
				ResultSet rs = stat.getGeneratedKeys();
				if (rs.next()) {
					codigosBilhetes.add(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return codigosBilhetes;
	}

	/**
	 * Método para listagem de zonas disponiveis (não bloqueadas) para serem
	 * mostradas na compra de bilhete ao escolher a zona.
	 * 
	 * @param idEvento : ID do Evento
	 * @return zonas do evento que não foram bloqueadas
	 */

	public static ObservableList<Integer> getZonasDisponiveis(int idEvento) {
		Connection conn = DBConnector.getConnection();
		ObservableList<Integer> zonasDisponiveis = FXCollections.observableArrayList();
		String sql = "SELECT zonaID_ev_zon from evento_zona WHERE isIndisponivel = 0 and eventoID_ev_zon = ?";
		try (PreparedStatement stat = conn.prepareStatement(sql)) {
			stat.setInt(1, idEvento);
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				zonasDisponiveis.add(rs.getInt("zonaID_ev_zon"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return zonasDisponiveis;

	}

	public static Integer getUserID(String pass) {
		String sql = "select userID from utilizador where pass = ?";
		Connection conn = DBConnector.getConnection();
		try (PreparedStatement stat = conn.prepareStatement(sql)) {
			stat.setString(1, pass);
			try (ResultSet rs = stat.executeQuery()) {
				while (rs.next()) {
					return rs.getInt("userID");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * Método responsável por listar número de lugares disponíveis por zona de cada
	 * evento
	 * 
	 * @param eventoID : ID do Evento
	 * @param zonaID   : ID da Zona
	 * @return Lugares Disponíveis
	 */

	public static ObservableList<Integer> getLugaresDisponiveis(int eventoID) {
		Connection conn = DBConnector.getConnection();
		int contador = 0;
		int zonaID = 0;
		ObservableList<Integer> lugaresDisponiveis = FXCollections.observableArrayList();
		String sql = "SELECT zonaID, (lugaresTotalZona - count(codigoBilhete)) as 'lugares' from zona\n"
				+ "				left join evento_zona ON zonaID_ev_zon = zonaID\n"
				+ "				left join bilhete ON eventoZonaID = eventoZonaID_bilhete\n"
				+ "				where eventoID_ev_zon = ? and isIndisponivel = 0 group by zonaID_ev_zon;";
		try (Statement st = conn.createStatement();
				ResultSet rse = st.executeQuery("SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));")) {

			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, eventoID);
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				zonaID = rs.getInt("zonaID");
				while ((zonaID - contador) > 1) {
					lugaresDisponiveis.add(0);
					contador++;
				}
				if ((zonaID - contador) <= 1) {
					contador++;
				}
				lugaresDisponiveis.add(rs.getInt("lugares"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lugaresDisponiveis;
	}
}

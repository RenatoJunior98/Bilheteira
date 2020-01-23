package bilheteira.models.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.PreparedStatement;

import bilheteira.models.Event;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * EventlistDAO é uma classe de ligação entre a base de dados e o java. Contem a
 * ObservableList nZonas que tem a lista de id´s das zonas
 * 
 * @author Renato Júnior
 */
public final class EventListDAO {

	private EventListDAO() {
	}

	static ObservableList<Integer> nZonas = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
			14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24);

	/**
	 * Metodo getEventsList obtem a partir da base de dados a lista de eventos e
	 * guarda na ObservableList EventsList EventsList; 
	 * Faz a conexão à base de dados a partir
	 * do metodo getConnection da classe DBConnector
	 * 
	 * @return a ObservableList EventsList com a lista de eventos guardados na base
	 *         de dados
	 */
	public static ObservableList<Event> getEventsLists() {
		ObservableList<Event> EventsLists = FXCollections.observableArrayList();
		Connection conn = DBConnector.getConnection();
		try (Statement stat = conn.createStatement();
				ResultSet rs = stat
						.executeQuery("SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));")) {

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Statement stat = conn.createStatement();
				ResultSet rs2 = stat.executeQuery("select * from evento group by eventoID ")) {
			while (rs2.next()) {
				String name = rs2.getString("nome");
				int eventoID = rs2.getInt("eventoID");
				double precoBase = rs2.getInt("precoBase");
				String dataHora = rs2.getString("dia");
				PreparedStatement st = conn.prepareStatement("select  count(codigoBilhete) as 'lugares' from bilhete\n"
						+ "							inner join evento_zona ON eventoZonaID_bilhete = eventoZonaID\n"
						+ "							left join evento on eventoID_ev_zon = eventoID\n"
						+ "							where eventoID = ? and isDevolvido = 0");
				st.setInt(1, eventoID);
				ResultSet rs3 = st.executeQuery();
				if (rs3.next()) {
					int lugaresVendidos = rs3.getInt(1);
					PreparedStatement stats = conn
							.prepareStatement("select sum(lugaresTotalZona) from zona inner join evento_zona "
									+ "on zonaID = zonaID_ev_zon where isIndisponivel = 0 and eventoID_ev_zon = ?");
					stats.setInt(1, eventoID);
					ResultSet rs4 = stats.executeQuery();
					if (rs4.next()) {
						int lugaresDisponiveis = rs4.getInt("sum(lugaresTotalZona)") - lugaresVendidos;
						EventsLists.add(new Event(eventoID, name, dataHora, precoBase, lugaresDisponiveis));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(EventsLists.size());
		return EventsLists;
	}

	/**
	 * Metodo saveEvento é dedicado a introduzir um novo evento na base de dados;
	 * Recebe um evento para ser introduzido; Faz a conexão à base de dados a partir
	 * do metodo getConnection da classe DBConnector
	 * 
	 * @param nome: nome do evento
	 * @param precoBase: Preço base do evento (preço da zona mais barata)
	 * @param dataHora: data e hora do evento
	 */
	public static void saveEvento(String nome, double precoBase, String dataHora) {
		int eventID = 0;
		String sql = "Insert into evento (nome, precoBase, dia) values (?,?,?)";
		Connection conn = DBConnector.getConnection();
		try (java.sql.PreparedStatement stat = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stat.setString(1, nome);
			stat.setDouble(2, precoBase);
			stat.setString(3, dataHora);
			stat.executeUpdate();
			ResultSet rs = stat.getGeneratedKeys();
			if (rs.next()) {
				eventID = rs.getInt(1);
			}
			System.out.println(dataHora);
			saveEventoZona(eventID);
		} catch (SQLException e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
	}

	public static int getPortaoID(int zonaID) {
		String sql = "select portao from zona where zonaID = ?";
		Connection conn = DBConnector.getConnection();
		try (PreparedStatement stat = conn.prepareStatement(sql)) {
			stat.setInt(1, zonaID);
			try (ResultSet rs = stat.executeQuery()) {
				while (rs.next()) {
					return rs.getInt("portao");
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public static String getEventoData(int eventoID) {
		String sql = "select nome dia from evento where eventoID = ?";
		Connection conn = DBConnector.getConnection();
		try (PreparedStatement stat = conn.prepareStatement(sql)) {
			stat.setInt(1, eventoID);
			try (ResultSet rs = stat.executeQuery()) {
				while (rs.next()) {
					return rs.getString("dia");
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String getEventoNome(int eventoID) {
		String sql = "select nome from evento where eventoID = ?";
		String nome = null;
		Connection conn = DBConnector.getConnection();
		try (PreparedStatement stat = conn.prepareStatement(sql)) {
			stat.setInt(1, eventoID);
			try (ResultSet rs = stat.executeQuery()) {
				while (rs.next()) {
					nome = rs.getString("nome");

					System.out.println("/n/n/n/n/n/n " + nome);
				}
			}

		} catch (SQLException e) {
			System.out.println("/n/n/n/n/n/n/n Erron no getEventoNome");
			e.printStackTrace();
		}
		return nome;
	}

	/**
	 * Metodo saveEvento é dedicado a introduzir um novo evento na tabela EventoZona
	 * na base de dados; Recebe um eventoID para criar elementos dessa tabela;
	 * Contem a ObservableList nZonas com as zonas do estadio criado, que é o outro
	 * atributo necessario para ser inserido um novo elemento; Faz a conexão à base
	 * de dados a partir do metodo getConnection da classe DBConnector
	 */
	public static void saveEventoZona(int eventoID) {
		String slqEZ = "insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (?,?)";
		Connection conn = DBConnector.getConnection();
		try (java.sql.PreparedStatement stat = conn.prepareStatement(slqEZ)) {
			for (int i : nZonas) {
				stat.setInt(1, eventoID);
				stat.setInt(2, i);
				stat.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void zonaIndisponivel(ObservableList<Integer> zonasIndisponiveis) {
		int eventoID = 0;
		Connection conn = DBConnector.getConnection();
		try (PreparedStatement stat = conn.prepareStatement("  SELECT MAX(eventoID) from evento;")) {
			ResultSet rs = stat.executeQuery();
			if (rs.next()) {
				eventoID = rs.getInt(1);
				System.out.println("EVENTOID --------------------------------------  " + eventoID);
			}
			for (int i : zonasIndisponiveis) {
				PreparedStatement stats = conn.prepareStatement("UPDATE evento_zona " + "SET isIndisponivel = 1 "
						+ "WHERE eventoID_ev_zon = ? and zonaID_ev_zon = ?;");
				stats.setInt(1, eventoID);
				stats.setInt(2, i);
				stats.execute();
				System.out.println("zona Cancelada ---------- " + zonasIndisponiveis);

			}
		} catch (SQLException e) {
			System.out.println("Nao cancelou");
			e.printStackTrace();
		}

	}
}

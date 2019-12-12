package bilheteira.models.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bilheteira.models.Event;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public final class EventListDAO {
	
	private EventListDAO() {}
	
	static ObservableList<Integer> nZonas = FXCollections
			.observableArrayList (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24);
	public static ObservableList<Event> getEventsLists() {
		ObservableList<Event> EventsLists =
				FXCollections.observableArrayList();
		Connection conn =  DBConnector.getConnection();
		try (Statement stat = conn.createStatement();
				ResultSet rs = 
						stat.executeQuery("Select * from evento"))
		{
			while (rs.next()) {
				String name= rs.getString("nome");
				int eventoID = rs.getInt("eventoID");
				double precoBase = rs.getInt("precoBase");
				String dia =rs.getString ("dia");
				//int lugaresDisponiveis = rs.getInt("lugaresDisponiveis");
				EventsLists.add(new Event(eventoID,name,dia,precoBase));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return EventsLists;
	}

	public static void saveEvento(String nome, double precoBase, String dia) {
		int eventID = 0;
		String sql = "Insert into evento (nome, precoBase, dia) values (?,?,?)";
		Connection conn=DBConnector.getConnection();
		try (java.sql.PreparedStatement stat=
				conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
		//stat.setInt(0, eventoID);
		stat.setString(1, nome);
		stat.setDouble(2, precoBase);
		stat.setString(3, dia);
		stat.executeUpdate();
		ResultSet rs = stat.getGeneratedKeys();
		if (rs.next()){
		    eventID=rs.getInt(1);
		}
		System.out.println(dia);
		saveEventoZona (eventID);
		} 
		catch (SQLException e) { System.out.println("Fail"); 
			e.printStackTrace();
			} 	
	}
	public static void saveEventoZona (int eventoID) {
		String slqEZ = "insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (?,?)";
		Connection conn=DBConnector.getConnection();
		try (java.sql.PreparedStatement stat=
		conn.prepareStatement(slqEZ)) {
			for (int i : nZonas) {
				stat.setInt(1, eventoID);
				stat.setInt(2, i);
				stat.executeUpdate();
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

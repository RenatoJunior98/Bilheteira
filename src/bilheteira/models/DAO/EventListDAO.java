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
				int precoBase = rs.getInt("precoBase");
				String dia =rs.getString ("dia");
				int lugaresDisponiveis = rs.getInt("lugaresDisponiveis");
				EventsLists.add(new Event(eventoID,name,dia,precoBase,lugaresDisponiveis));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return EventsLists;
	}
}

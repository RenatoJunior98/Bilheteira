package bilheteira.models.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

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
		String sql =
		"Insert into evento (nome, precoBase, dia) values (?,?,?)";
		Connection conn=DBConnector.getConnection();
		try (java.sql.PreparedStatement stat=
		conn.prepareStatement(sql)) {
		//stat.setInt(0, eventoID);
		stat.setString(1, nome);
		stat.setDouble(2, precoBase);
		stat.setString(3, dia);
		stat.executeUpdate();
		System.out.println(dia);
		} catch (SQLException e) { System.out.println("Fail"); 
			e.printStackTrace();} }


}

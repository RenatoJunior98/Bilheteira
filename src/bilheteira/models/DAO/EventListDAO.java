package bilheteira.models.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.view.EventsList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public final class EventListDAO {

	private EventListDAO() {}

	public static ObservableList<EventsList> getEventsLists() {
		ObservableList<EventsList> EventsLists =
				FXCollections.observableArrayList();
		Connection conn =  DBConnector.getConnection();
		try (Statement stat = conn.createStatement();
				ResultSet rs = 
						stat.executeQuery("Select * from evento"))
		{
			while (rs.next()) {
				String name= rs.getString("nome");
				int id = rs.getInt("id");
				int precoBase = rs.getInt("precoBase");
				String dia =rs.getString ("dia");
				int lugaresDisponiveis = rs.getInt("lugaresDisponiveis");
				EventsLists.add(new EventsList(id,name,dia,precoBase,lugaresDisponiveis));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return EventsLists;
	}
}
/*
	public static ObservableList<EventsList> getShopListItems(int id) {
		ObservableList<EventsList> itens =
				FXCollections.observableArrayList();
		Connection conn =  DBConnector.getConnection();
		String sql = "Select enventoID,nome,dia,precoBase,LugaresDisponiveis "+
				" from evento;";
		try (PreparedStatement stat = conn.prepareStatement(sql)){
			stat.setInt(1,id);
			try(ResultSet rs = stat.executeQuery()) {
				while (rs.next()) {
					String nome = rs.getString("nome");
					int id = rs.getInt("id");
					String dia = rs.getString("dia");
					double precoBase = rs.getDouble("precoBase");
					int lugaresDisponiveis = rs.getInt("lugaresDisponiveis");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return evento;
	}
}
*/

// A static block is called the first time the class
// is used 
// We will use it to initialize all static attributes
/*
  	static {

		ObservableList<Item> items = 
				FXCollections.observableArrayList();
		shopLists.add(new ShopList("Compras de Natal",items));
		// I can add items after adding the lost to shoplist
		// The shoplist has a reference to the same list as "items"
		items.add(new Item(1,new Product("Peru 2kg",10.4)));
		items.add(new Item(4.0,new Product("Batatas",0.9)));
		items.add(new Item(0.5,
				new ImportedProduct("Chocolate Belga",2.3,"França","L&A")));
		items = FXCollections.observableArrayList();
		shopLists.add(new ShopList("Compras de Novembro",items));
		items.add(new Item(4.0,new Product("Batatas",0.9)));
		items.add(new Item(4.0,new Product("Cebolas",0.56)));
	}
 */





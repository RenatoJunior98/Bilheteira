package application.view;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;


//public class ItemListView<T extends ImageItemizable>
public class EventListView<T extends ImageItemizable> {
extends ListView<T> {
	public EventListView() {
		setCellFactory((listView) -> {
			return new ListCell<T>() {
				public void updateItem(T item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null || empty) {
						// nullify all content if no item exists
						setText(null);
						setGraphic(null);
					}  else {
						try {
							FXMLLoader loader = new FXMLLoader(
									getClass().getResource("itemView.fxml"));
							loader.setController(new ItemController(item));
							Parent node = loader.load();
							setText(null);
							setGraphic(node);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} 
			};
		});
	}

	
}
package application.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class CreateEventController {

	private ObservableList<String> CategoryList = FXCollections
			.observableArrayList ("Jogo de Desporto","Concerto","Espetáculo","Outro");
	


	@FXML
    private ComboBox<String> categoryBox;
	
	@FXML
	public void initialize () {
		categoryBox.setItems(CategoryList);
	}
}

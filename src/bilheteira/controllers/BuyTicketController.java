package bilheteira.controllers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class BuyTicketController {


	private ObservableList<Integer> EscolherZona = FXCollections
			.observableArrayList (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24);

	@FXML
    private ComboBox<Integer> escolherZona;
	
	private ObservableList<Integer> NBilhetes = FXCollections
			.observableArrayList (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30);

	@FXML
    private ComboBox<Integer> nBilhetes;
	
	@FXML
	public void initialize () {
		escolherZona.setItems(EscolherZona);
		nBilhetes.setItems(NBilhetes);
	}

	public Integer getZonaID () {
		Integer selectedChoice = escolherZona.getSelectionModel().getSelectedItem();
		return selectedChoice;
	}
	
//	public Integer getNBilhetes () {
//		Integer selectedChoice = nBilhetes.getSelectionModel().getSelectedItem();
//		return selectedChoice;
//	}
	
}

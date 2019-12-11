package bilheteira.controllers;

import java.time.format.DateTimeFormatter;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import bilheteira.models.DAO.EventListDAO;
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

	
	@FXML
    private JFXTextField nome;
	
	@FXML
    private JFXTextField precoBase;
	
	@FXML
    private JFXTimePicker hora;
	
	@FXML
    private JFXDatePicker dia;
	

	public void inserir () {
		String data = dia.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd "))
				.concat(hora.getValue().format(DateTimeFormatter.ofPattern("hh:mm a")));

		EventListDAO.saveEvento(nome.getText(), Double.valueOf(precoBase.getText()), data);
		
	}

}

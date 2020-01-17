package bilheteira.controllers;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import application.Main;
import bilheteira.models.DAO.EventListDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

/**
 * Classe que controla a função de criar um evento (uma das opções dadas no Main Stage)
 * Contem a ComboBox das categorias do evento, Date Picker , Time Picker, e é pedido um preço base do evento ( que postriormente será necessario para calcular o preço final do bilhete ) 
 * @author Ricardo Cruz
 *
 */

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
    private JFXDatePicker data;
	
/**
 * Este método é chamado ao clicar no botão da submissão do evento criado, para os dados inseridos na criação do evento serem guardados na base de dados
 * É chamado neste método, o método saveEvento da classe EventoListDAO para a Base de dados conseguir guardadar esses dados sobre o evento criado
 */
	public void inserir () {
		String dataHora = data.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd "))
				.concat(hora.getValue().format(DateTimeFormatter.ofPattern("hh:mm a")));

		EventListDAO.saveEvento(nome.getText(), Double.valueOf(precoBase.getText()), dataHora);
		
		try {
			Main.createNewWindow("view/CreateEventZonas.fxml", new SelectZoneController());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

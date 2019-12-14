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

/**
 * Classe que controla a fun��o de criar um evento (uma das op��es dadas no Main Stage)
 * Contem a ComboBox das categorias do evento, Date Picker , Time Picker, e � pedido um pre�o base do evento ( que postriormente ser� necessario para calcular o pre�o final do bilhete ) 
 * @author Ricardo Cruz
 *
 */

public class CreateEventController {

	private ObservableList<String> CategoryList = FXCollections
			.observableArrayList ("Jogo de Desporto","Concerto","Espet�culo","Outro");

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
    private JFXDatePicker dataHora;
	
/**
 * Este m�todo � chamado ao clicar no bot�o da submiss�o do evento criado, para os dados inseridos na cria��o do evento serem guardados na base de dados
 * � chamado neste m�todo, o m�todo saveEvento da classe EventoListDAO para a Base de dados conseguir guardadar esses dados sobre o evento criado
 */
	public void inserir () {
		String data = dataHora.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd "))
				.concat(hora.getValue().format(DateTimeFormatter.ofPattern("hh:mm a")));

		EventListDAO.saveEvento(nome.getText(), Double.valueOf(precoBase.getText()), data);
		
	}

}

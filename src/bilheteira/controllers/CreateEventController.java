package bilheteira.controllers;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import application.Main;
import bilheteira.models.DAO.EventListDAO;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

/**
 * Classe que controla a função de criar um evento (uma das opções dadas no Main
 * Stage) Contem Date Picker , Time Picker, e é pedido um preço base do evento (
 * que postriormente será necessario para calcular o preço final do bilhete )
 * Depois de comcluido é possivel escolher zonas para bloquear(zonas não
 * disponiveis para o evento em questão)
 * 
 * @author Ricardo Cruz
 *
 */

public class CreateEventController {

	@FXML
	private ComboBox<String> categoryBox;

	@FXML
	public void initialize() {
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
	 * Este método é chamado ao clicar no botão da submissão do evento criado, para
	 * os dados inseridos na criação do evento serem guardados na base de dados. É
	 * chamado neste método, o método saveEvento da classe EventoListDAO para a Base
	 * de dados conseguir guardadar esses dados sobre o evento criado. É aberta uma
	 * janela onde o utilizador pode então selecionar zonas indisponiveis
	 */
	public void inserir() {
		String dataHora = data.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd "))
				.concat(hora.getValue().format(DateTimeFormatter.ofPattern("hh:mm a")));

		EventListDAO.saveEvento(nome.getText(), Double.valueOf(precoBase.getText()), dataHora);

		try {
			Main.getCurrentStage().close();
			Main.createNewWindow("view/CreateEventZonas.fxml", new SelectZoneController());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

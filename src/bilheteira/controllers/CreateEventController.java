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
 * Classe que controla a fun��o de criar um evento (uma das op��es dadas no Main
 * Stage) Contem Date Picker , Time Picker, e � pedido um pre�o base do evento (
 * que postriormente ser� necessario para calcular o pre�o final do bilhete )
 * Depois de comcluido � possivel escolher zonas para bloquear(zonas n�o
 * disponiveis para o evento em quest�o)
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
	 * Este m�todo � chamado ao clicar no bot�o da submiss�o do evento criado, para
	 * os dados inseridos na cria��o do evento serem guardados na base de dados. �
	 * chamado neste m�todo, o m�todo saveEvento da classe EventoListDAO para a Base
	 * de dados conseguir guardadar esses dados sobre o evento criado. � aberta uma
	 * janela onde o utilizador pode ent�o selecionar zonas indisponiveis
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

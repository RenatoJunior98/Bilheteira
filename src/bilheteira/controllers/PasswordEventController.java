package bilheteira.controllers;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

/**
 * Classe que controla o FXML da password pedida antes de o utilizador poder criar um evento
 * Contem uma caixa de texto onde o utilizador dever� inserir a password corretamente
 * (Fun�ao temporaria)
 * @author Ricardo Cruz
 *
 */
public class PasswordEventController {

	@FXML
	Button enterButton;
	@FXML
	PasswordField password;
	
	/**
	 * Metodo chamado ao clicar no bot�o confirmar pass, � verificado se foi inserida a password correta
	 * Se for correta abre o FXML CreateEvent, onde o utilizador poder� criar um evento
	 */
	public void onEnterButtonClicked () {
		try {
			if (password.getText().equals("admin")) {
			Main.getCurrentStage().close();
			Main.createNewWindow("view/CreateEvent.fxml", new CreateEventController());
			}
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}

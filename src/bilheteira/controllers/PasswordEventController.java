package bilheteira.controllers;

import java.io.IOException;

import application.Main;
import bilheteira.models.DAO.BuyTicketDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

/**
 * Classe que controla o FXML da password pedida antes de o utilizador poder
 * criar um evento Contem uma caixa de texto onde o utilizador deverá inserir a
 * password corretamente
 * 
 * @author Ricardo Cruz
 *
 */
public class PasswordEventController {

	@FXML
	Button enterButton;
	@FXML
	PasswordField password;

	private String janela;

	public PasswordEventController(String janela) {
		this.janela = janela;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo chamado ao clicar no botão confirmar pass, é verificado se foi
	 * inserida a password correta. Se for correta abre o FXML onde o utilizador
	 * poderá criar um evento ou ver a tabela com os eventos
	 */
	public void onEnterButtonClicked() {

		try {
			if (janela == "bilhete") {
				if (password.getText().equals("123456") || password.getText().equals("1234")){
				Main.createNewWindow("view/ViewEvents.fxml",
						new ViewEventsController(BuyTicketDAO.getUserID(password.getText())));
			}
			}
			if (password.getText().equals("admin")) {
				Main.getCurrentStage().close();
				if (janela == "evento") {
					Main.createNewWindow("view/CreateEvent.fxml", new CreateEventController());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

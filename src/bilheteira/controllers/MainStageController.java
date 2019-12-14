package bilheteira.controllers;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;

	/**
	 * Classe que controla a Main Stage (primeiro FXML que aparece ao iniciar a aplicação)
	 * Contem os métodos que são chamados ao clicar nas opções do menu principal ( Main Stage )
	 * @author Ricardo Cruz
	 *
	 */

public class MainStageController {
	
	/**
	 * Este método é chamado ao clicar no botão para comprar bilhete
	 * Irá abrir a janela do ViewEvents.fxml que contem a table view dos eventos criados e alojados na Base de dados
	 * Este novo FXML aberto tem como controlador ViewEventsController()
	 */
	@FXML
	public void onViewEvents () {
		try {
			Main.createNewWindow("view/ViewEvents.fxml", new ViewEventsController());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Este método é chamado ao clicar no botão para criar evento
	 * Irá abrir a janela do PasswordEvent.fxml que pede ao utilizador para inserir uma password
	 * Este novo FXML aberto tem como controlador PasswordEventController()
	 */
	public void onCreateEvent () {
		try {
			Main.createNewWindow("view/PasswordEvent.fxml", new PasswordEventController());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Este método é chamado ao clicar no botão para trocar bilhete
	 * Irá abrir a janela do Refound.fxml que pede ao utilizador para inserir o codigo do bilhete que pretende devolver/trocar
	 * (este metodo não está implemetado no momento)
	 */
	public void onRefound () {
		try {
			Main.createNewWindow("view/Refound.fxml", null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

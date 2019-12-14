package bilheteira.controllers;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;

	/**
	 * Classe que controla a Main Stage (primeiro FXML que aparece ao iniciar a aplica��o)
	 * Contem os m�todos que s�o chamados ao clicar nas op��es do menu principal ( Main Stage )
	 * @author Ricardo Cruz
	 *
	 */

public class MainStageController {
	
	/**
	 * Este m�todo � chamado ao clicar no bot�o para comprar bilhete
	 * Ir� abrir a janela do ViewEvents.fxml que contem a table view dos eventos criados e alojados na Base de dados
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
	 * Este m�todo � chamado ao clicar no bot�o para criar evento
	 * Ir� abrir a janela do PasswordEvent.fxml que pede ao utilizador para inserir uma password
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
	 * Este m�todo � chamado ao clicar no bot�o para trocar bilhete
	 * Ir� abrir a janela do Refound.fxml que pede ao utilizador para inserir o codigo do bilhete que pretende devolver/trocar
	 * (este metodo n�o est� implemetado no momento)
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

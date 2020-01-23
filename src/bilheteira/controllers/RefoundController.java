package bilheteira.controllers;

import java.io.IOException;

import application.Main;
import bilheteira.models.DAO.RefundTicketDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Método controller da função Refund. É responsável por ler o código inserido
 * na caixa de texto e chamar o método da classe DAO.
 * 
 * @author Ricardo Cruz
 *
 */

public class RefoundController {

	@FXML
	private TextField codigoBilhete;

	/**
	 * Método initialize da classe
	 */

	@FXML
	public void initialize() {
	}

	/**
	 * Método chamado ao clicar no botão "Confirmar". Chama o método da classe DAO,
	 * que faz a mudança na base de dados. Abre a janela que mostra o preço a que o
	 * bilhete foi comprado.
	 */

	@FXML
	public void confirmarCodigo() {
		RefundTicketDAO.refundTicket(Integer.valueOf(codigoBilhete.getText()));
//10168925
		try {
			Main.createNewWindow("view/RefoundPreço.fxml", new RefundPriceController(codigoBilhete));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

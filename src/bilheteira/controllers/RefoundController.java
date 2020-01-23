package bilheteira.controllers;

import java.io.IOException;

import application.Main;
import bilheteira.models.DAO.RefundTicketDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * M�todo controller da fun��o Refund. � respons�vel por ler o c�digo inserido
 * na caixa de texto e chamar o m�todo da classe DAO.
 * 
 * @author Ricardo Cruz
 *
 */

public class RefoundController {

	@FXML
	private TextField codigoBilhete;

	/**
	 * M�todo initialize da classe
	 */

	@FXML
	public void initialize() {
	}

	/**
	 * M�todo chamado ao clicar no bot�o "Confirmar". Chama o m�todo da classe DAO,
	 * que faz a mudan�a na base de dados. Abre a janela que mostra o pre�o a que o
	 * bilhete foi comprado.
	 */

	@FXML
	public void confirmarCodigo() {
		RefundTicketDAO.refundTicket(Integer.valueOf(codigoBilhete.getText()));
//10168925
		try {
			Main.createNewWindow("view/RefoundPre�o.fxml", new RefundPriceController(codigoBilhete));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

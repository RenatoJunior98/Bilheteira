package bilheteira.controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;

import bilheteira.models.DAO.RefundTicketDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * Classe controller da visualiza��o do pre�o do bilhete devolvido anteriormente
 * 
 * @author Ricardo Cruz
 *
 */

public class RefundPriceController {

	@FXML
	private Text precoBilheteText;
	private TextField codigoBilhete;
	private double precoBilhete = 0;
	private String sPreco;

	public RefundPriceController(TextField codigoBilhete) {
		this.codigoBilhete = codigoBilhete;
	}

	/**
	 * M�todo initialize da classe Inicia o m�todo "mostrarPre�o"
	 */

	@FXML
	public void initialize() {
		mostrarPreco();
	}

	/**
	 * M�todo que � chamado ao iniciar a janela. Tem como objetivo mostrar o pre�o
	 * do bilhete devolvido
	 */
	public void mostrarPreco() {
		precoBilhete = RefundTicketDAO.getPreco(Integer.valueOf(codigoBilhete.getText()));
		BigDecimal bd = new BigDecimal(precoBilhete).setScale(2, RoundingMode.HALF_UP);
		precoBilhete = bd.doubleValue();
		sPreco = String.valueOf(precoBilhete);
		precoBilheteText.setText(sPreco);
	}
}

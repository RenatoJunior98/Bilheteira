package bilheteira.controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;

import bilheteira.models.DAO.RefundTicketDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * Classe controller da visualização do preço do bilhete devolvido anteriormente
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
	 * Método initialize da classe Inicia o método "mostrarPreço"
	 */

	@FXML
	public void initialize() {
		mostrarPreco();
	}

	/**
	 * Método que é chamado ao iniciar a janela. Tem como objetivo mostrar o preço
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

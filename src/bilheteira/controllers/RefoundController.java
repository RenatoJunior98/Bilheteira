package bilheteira.controllers;

import java.io.IOException;

import application.Main;
import bilheteira.models.DAO.RefundTicketDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RefoundController {

	@FXML
	private TextField codigoBilhete;
	
	
	@FXML
	public void initialize () {	
	}
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

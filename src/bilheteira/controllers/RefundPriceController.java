package bilheteira.controllers;

import bilheteira.models.DAO.RefundTicketDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RefundPriceController {

	@FXML
	private Text precoBilheteText;
	private TextField codigoBilhete;
	private double precoBilhete = 0;
	private String sPreco;
	public RefundPriceController(TextField codigoBilhete) {
		this.codigoBilhete = codigoBilhete;
	}
	@FXML
	public void initialize () {
		MostrarPreco();
	}	
	public void MostrarPreco () {
	precoBilhete = RefundTicketDAO.getPreco(Integer.valueOf(codigoBilhete.getText()));
	sPreco = String.valueOf(precoBilhete);
	System.out.println("------"+precoBilhete);
	System.out.println(sPreco);
	precoBilheteText.setText(sPreco);
	}
}

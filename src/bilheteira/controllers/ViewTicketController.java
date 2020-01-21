package bilheteira.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

public class ViewTicketController {

	@FXML
    private Text nomeEvento;
	
	@FXML
    private Text dataHora;
	
	@FXML
    private Text precoFinal;
	
	@FXML
	private Text zona;
	
	@FXML
	private Text portao;
	
	@FXML
    private ComboBox <Integer> codigoBilhete;
	
	
	@FXML
	public void initialize () {
		
	}
	
	
	
}

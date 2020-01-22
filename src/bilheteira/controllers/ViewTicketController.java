package bilheteira.controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;

import bilheteira.models.DAO.EventListDAO;
import bilheteira.models.DAO.RefundTicketDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

public class ViewTicketController {

	ObservableList <Integer> codigosBilhetes =FXCollections.observableArrayList();
	String data;
	String eventoNome;
	private int eventoID;
	private double precoTotalBilhete = 0;	
	private double precoBilhete = 0;
	private int zonaID;
	
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
	

	public ViewTicketController(ObservableList<Integer> codigosBilhetes, String eventoNome, Integer eventoID, Integer zonaID, String data) {
		for (int i: codigosBilhetes) {
			precoTotalBilhete += RefundTicketDAO.getPreco(i);
		}
		precoBilhete = RefundTicketDAO.getPreco(codigosBilhetes.get(0));
		BigDecimal bd = new BigDecimal(precoTotalBilhete).setScale(2, RoundingMode.HALF_UP);
        precoTotalBilhete = bd.doubleValue();
			this.eventoID = eventoID;
			this.zonaID = zonaID;
			this.eventoNome = eventoNome;
			this.data = data;
			this.codigosBilhetes = codigosBilhetes;
	}


	@FXML
	public void initialize () {
		nomeEvento.setText(eventoNome);
		dataHora.setText(data);
		precoFinal.setText(String.valueOf(precoTotalBilhete));
		zona.setText(String.valueOf(zonaID));
		portao.setText(String.valueOf(EventListDAO.getPortaoID(zonaID)));
		codigoBilhete.setItems(codigosBilhetes);
	}
	
	
	
}

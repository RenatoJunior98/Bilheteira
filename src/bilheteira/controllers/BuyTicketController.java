package bilheteira.controllers;
import java.io.IOException;

import application.Main;
import bilheteira.models.Event;
import bilheteira.models.DAO.BuyTicketDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

/**
 * Classe que controla a fun��o de comprar bilhete 
 * Contem a ComboBox das categorias do evento, Date Picker , Time Picker, e � pedido um pre�o base do evento ( que postriormente ser� necessario para calcular o pre�o final do bilhete ) 
 * @author Ricardo Cruz
 *
 */
public class BuyTicketController {


	private ObservableList<Integer> EscolherZona = FXCollections
			.observableArrayList (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24);

	@FXML
    private ComboBox<Integer> escolherZona;
	
	private ObservableList<Integer> NBilhetes = FXCollections
			.observableArrayList (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30);

	@FXML
    private ComboBox<Integer> nBilhetes;
	
	private Event event;
	
	public BuyTicketController(Event event) {
		this.event = event;
	}
	
	/**
	 * M�todo initialize da classe BuyTicketController
	 * Faz o preenchimento das ComboBoxs da quantidade de bilhetes e da escolha da zona
	 */
	@FXML
	public void initialize () {
		escolherZona.setItems(EscolherZona);
		nBilhetes.setItems(NBilhetes);
		
	}
	
	/**
	 * Este m�todo � chamado ao clicar no bot�o comprar bilhete, para os dados inseridos na compra do/dos bilhetes (ainda s� � poss�vel comprar um bilhete) serem guardados na base de dados
	 * � chamado o m�todo saveEvento da classe EventoListDAO para a Base de dados conseguir guardadar esses dados sobre a compra do/dos bilhetes
	 */
	@FXML
	private void comprar() {
		BuyTicketDAO.saveBilhete(event.getEventoID(), escolherZona.getValue(), nBilhetes.getValue());
		
		try {
			Main.createNewWindow("view/ViewTicket.fxml", new ViewTicketController());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}

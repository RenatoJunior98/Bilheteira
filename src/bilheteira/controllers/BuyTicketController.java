package bilheteira.controllers;
import java.io.IOException;

import application.Main;
import bilheteira.models.Event;
import bilheteira.models.DAO.BuyTicketDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

/**
 * Classe que controla a função de comprar bilhete 
 * Contem a ComboBox das categorias do evento, Date Picker , Time Picker, e é pedido um preço base do evento ( que postriormente será necessario para calcular o preço final do bilhete ) 
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
	
	private ObservableList<Text> zonasText = FXCollections.observableArrayList();
	
	@FXML
    private Text z1,z2,z3,z4,z5,z6,z7,z8,z9,z10,z11,z12,z13,z14,z15,z16,z17,z18,z19,z20,z21,z22,z23,z24,z25;
	
	private Event event;
	
	public BuyTicketController(Event event) {
		this.event = event;
		
	}
	
	
	/**
	 * Método initialize da classe BuyTicketController
	 * Faz o preenchimento das ComboBoxs da quantidade de bilhetes e da escolha da zona
	 */
/*	@FXML
	public void initialize () {
		escolherZona.setItems(EscolherZona);
		nBilhetes.setItems(NBilhetes);
		zonasText.addAll(z1,z2,z3,z4,z5,z6,z7,z8,z9,z10,z11,z12,z13,z14,z15,z16,z17,z18,z19,z20,z21,z22,z23,z24,z25);
		
		ObservableList <Integer> zonas = BuyTicketDAO.getZonasDisponiveis(event.getEventoID());
		for(int i = 0; i< zonas.size(); i++){
			  zonasText.get(i).setText(String.valueOf(BuyTicketDAO.getLugaresDisponiveis(i)));
			}
		
	} */
	
	@FXML
	public void initialize () {
		escolherZona.setItems(EscolherZona);
		nBilhetes.setItems(NBilhetes);
		zonasText.addAll(z1,z2,z3,z4,z5,z6,z7,z8,z9,z10,z11,z12,z13,z14,z15,z16,z17,z18,z19,z20,z21,z22,z23,z24,z25);
		
		ObservableList <Integer> zonas = BuyTicketDAO.getZonasDisponiveis(event.getEventoID());
		
		ObservableList <Integer> lugaresDisponiveis = BuyTicketDAO.getLugaresDisponiveis(event.getEventoID());
		for(int i = 0; i< zonas.size(); i++){
			  zonasText.get(i).setText(String.valueOf(lugaresDisponiveis.get(i)));
			}
		
	}
	
	
	
	/**
	 * Este método é chamado ao clicar no botão comprar bilhete, para os dados inseridos na compra do/dos bilhetes (ainda só é possível comprar um bilhete) serem guardados na base de dados
	 * É chamado o método saveEvento da classe EventoListDAO para a Base de dados conseguir guardadar esses dados sobre a compra do/dos bilhetes
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

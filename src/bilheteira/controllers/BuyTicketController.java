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
 * Classe que controla a fun��o de comprar bilhete 
 * Contem a ComboBox das categorias do evento, Date Picker , Time Picker, e � pedido um pre�o base do evento ( que postriormente ser� necessario para calcular o pre�o final do bilhete ) 
 * @author Ricardo Cruz
 *
 */
public class BuyTicketController {


	private ObservableList<Integer> EscolherZona = FXCollections
			.observableArrayList();// (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24);

	@FXML
    private ComboBox <Integer> escolherZona;
	
	private ObservableList<Integer> NBilhetes = FXCollections.observableArrayList();//(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30);
	private ObservableList<Integer> lugaresDisponiveis = FXCollections.observableArrayList();
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
	 * M�todo initialize da classe BuyTicketController
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
		
		escolherZona.setItems(BuyTicketDAO.getZonasDisponiveis(event.getEventoID()));
	//	nBilhetes.setItems(BuyTicketDAO.getLugaresDisponiveis(event.getEventoID(), 0));
		zonasText.addAll(z1,z2,z3,z4,z5,z6,z7,z8,z9,z10,z11,z12,z13,z14,z15,z16,z17,z18,z19,z20,z21,z22,z23,z24,z25);
		ObservableList <Integer> zonas = BuyTicketDAO.getZonasDisponiveis(event.getEventoID());
		for (int i=1; i< 25; i++) {
		lugaresDisponiveis.add(BuyTicketDAO.getLugaresDisponiveis(event.getEventoID(), i));
		}
		for (int i = 0; i< zonas.size(); i++){
			  zonasText.get(i).setText(String.valueOf(lugaresDisponiveis.get(i)));
			}
		
		
	}
	@FXML
	private void confirmarZona() {
			NBilhetes.clear();
		if (escolherZona.getSelectionModel().getSelectedItem() != null) {
			if ((BuyTicketDAO.getLugaresDisponiveis(event.getEventoID(), escolherZona.getSelectionModel().getSelectedItem())) < 16) {
				for (int i =1; i<= BuyTicketDAO.getLugaresDisponiveis(event.getEventoID(), escolherZona.getValue()); i++) {
					NBilhetes.add(i);
				}
			}
			
			else {
				NBilhetes.addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
			}
		}
		nBilhetes.setItems(NBilhetes);
	}
	
	
	/**
	 * Este m�todo � chamado ao clicar no bot�o comprar bilhete, para os dados inseridos na compra do/dos bilhetes (ainda s� � poss�vel comprar um bilhete) serem guardados na base de dados
	 * � chamado o m�todo saveEvento da classe EventoListDAO para a Base de dados conseguir guardadar esses dados sobre a compra do/dos bilhetes
	 */
	@FXML
	private void comprar() {
		//int selectedZona = 0;
		//selectedZona = escolherZona.getSelectionModel().getSelectedItem();
		BuyTicketDAO.saveBilhete(event.getEventoID(), escolherZona.getValue(), nBilhetes.getValue());
		
		try {
			Main.createNewWindow("view/ViewTicket.fxml", new ViewTicketController());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}

/*
 * public static void zonaIndisponivel (int zonaID) {
        int eventoID = 0;
        Connection conn = DBConnector.getConnection();
        try (PreparedStatement stat = conn.prepareStatement(
                "  SELECT LAST_INSERT_ID(eventoID) from evento;")){
            ResultSet rs = stat.getGeneratedKeys();
            if (rs.next()){
                eventoID=rs.getInt(1);
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try (PreparedStatement stat = conn.prepareStatement(
                "delete from evento_zona where eventoID_ev_zon = ? and zonaID_ev_zon = ?;\n")) {
            stat.setInt(1, eventoID);
            stat.setInt(2, zonaID);
            }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/
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
 * Classe que controla a função de comprar bilhete Contem a ComboBox da escolha
 * de zona e numero de bilhetes
 * 
 * @author Ricardo Cruz
 *
 */
public class BuyTicketController {


	@FXML
	private ComboBox<Integer> escolherZona;

	private ObservableList<Integer> NBilhetes = FXCollections.observableArrayList();
	private ObservableList<Integer> lugaresDisponiveis = FXCollections.observableArrayList();
	private ObservableList<Integer> codigosBilhetes = FXCollections.observableArrayList();

	@FXML
	private ComboBox<Integer> nBilhetes;

	private ObservableList<Text> zonasText = FXCollections.observableArrayList();

	@FXML
	private Text z1, z2, z3, z4, z5, z6, z7, z8, z9, z10, z11, z12, z13, z14, z15, z16, z17, z18, z19, z20, z21, z22,
			z23, z24, z25;

	private Event event;
	private int userID;

	public BuyTicketController(Event event, int userID) {
		this.event = event;
		this.userID = userID;
	}

	/**
	 * Método initialize da classe BuyTicketController. Faz o preenchimento dos
	 * lugares disponiveis em cada zona tendo em conta as zonas bloqueadas
	 * ("getZonasDisponiveis") em cada evento, das ComboBoxs da quantidade de
	 * bilhetes e da escolha da zona
	 */

	@FXML
	public void initialize() {

		escolherZona.setItems(BuyTicketDAO.getZonasDisponiveis(event.getEventoID()));
		zonasText.addAll(z1, z2, z3, z4, z5, z6, z7, z8, z9, z10, z11, z12, z13, z14, z15, z16, z17, z18, z19, z20, z21,
				z22, z23, z24, z25);
		ObservableList<Integer> zonas = BuyTicketDAO.getZonasDisponiveis(event.getEventoID());
		for (int i = 1; i < 25; i++) {
			lugaresDisponiveis.add(BuyTicketDAO.getLugaresDisponiveis(event.getEventoID(), i));
		}
		for (int i = 0; i < zonas.size(); i++) {
			zonasText.get(i).setText(String.valueOf(lugaresDisponiveis.get(i)));
		}

	}

	/**
	 * 
	 * Este método é chamado ao clicar no botão "Confirmar Zona", para a comboBox em
	 * baixo( Numero de bilhetes) ser atualizada com valor maximo de lugares
	 * disponiveis ou se for maior que 15, dar a opçáo de comprar até 15 bilhetes ao
	 * mesmo tempo para o mesmo evento e para a mesma zona
	 */

	@FXML
	private void confirmarZona() {
		NBilhetes.clear();
		if (escolherZona.getSelectionModel().getSelectedItem() != null) {
			if ((BuyTicketDAO.getLugaresDisponiveis(event.getEventoID(),
					escolherZona.getSelectionModel().getSelectedItem())) < 16) {
				for (int i = 1; i <= BuyTicketDAO.getLugaresDisponiveis(event.getEventoID(),
						escolherZona.getValue()); i++) {
					NBilhetes.add(i);
				}
			}

			else {
				NBilhetes.addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
			}
		}
		nBilhetes.setItems(NBilhetes);
	}

	/**
	 * Este método é chamado ao clicar no botão comprar bilhete, para os dados
	 * inseridos na compra do/dos bilhetes (ainda só é possível comprar um bilhete)
	 * serem guardados na base de dados É chamado o método saveEvento da classe
	 * EventoListDAO para a Base de dados conseguir guardadar esses dados sobre a
	 * compra do/dos bilhetes
	 */
	@FXML
	private void comprar() {

		codigosBilhetes.addAll(
				BuyTicketDAO.saveBilhete(event.getEventoID(), escolherZona.getValue(), nBilhetes.getValue(), userID));

		try {
			Main.createNewWindow("view/ViewTicket.fxml", new ViewTicketController(codigosBilhetes, event.getNome(),
					event.getEventoID(), escolherZona.getValue(), event.getDataHora()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
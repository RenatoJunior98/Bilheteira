package bilheteira.controllers;

import java.io.IOException;

import application.Main;
import bilheteira.models.Event;
import bilheteira.models.DAO.EventListDAO;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Classe que controla a função escolher o evento. Contem uma table view com os
 * elementos : id, nome, data e hora, preço base do evento e o número de lugares
 * disponíveis de cada evento
 * 
 * @author Ricardo Cruz
 *
 */
public class ViewEventsController {
	@FXML
	private TableView<Event> eventosTV;

	@FXML
	private TableColumn<Event, Integer> idColumn;

	@FXML
	private TableColumn<Event, String> nomeColumn;

	@FXML
	private TableColumn<Event, String> diaColumn;

	@FXML
	private TableColumn<Event, Double> precoBaseColumn;

	@FXML
	private TableColumn<Event, Integer> lugaresDisponiveisColumn;

	private int userID;

	public ViewEventsController(Integer userID) {
		this.userID = userID;
	}

	/**
	 * Metodo initialize da classe ViewEventsController Ao inicializar, este metodo
	 * popula a tabela. O metodo contem também um listener para o utilizador
	 * escolher o evento para o qual quer comprar bilhetes. Ao selecionar uma das
	 * linhas, é criada uma janela (BuyTicketWindow) onde é possivel comprar
	 * bilhetes para o evento anteriormente selecionado.
	 */
	@FXML
	public void initialize() {
		System.out.println("CARREGADO");
		idColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getEventoID()));
		nomeColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getNome()));
		diaColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getDataHora()));
		precoBaseColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getPrecoBase()));
		lugaresDisponiveisColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getLugaresDisponiveis()));

		eventosTV.setItems(EventListDAO.getEventsLists());

		eventosTV.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
			try {
				Main.createNewWindow("view/BuyTicketWindow.fxml", new BuyTicketController(newVal, userID));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
}

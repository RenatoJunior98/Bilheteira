package bilheteira.controllers;

import java.io.IOException;

import application.Main;
import bilheteira.models.Event;
import bilheteira.models.DAO.EventListDAO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Classe que controla a fun��o escolher o evento 
 * Contem uma table view com os elementos : id, nome, data e hora e pre�o base do evento
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
    
    private static ObservableList<Event> eventos;
  
    private Event evento;
    
    public ViewEventsController() {
    	
    }
    
    /**
     * Metodo initialize da classe ViewEventsController
     * Ao inicializar, este metodo popula a tabela 
     * O metodo contem tamb�m um listener para o utilizador escolher o evento para o qual quer comprar bilhetes
     * Ao selecionar uma das linhas, � criada uma janela (BuyTicketWindow) onde � possivel comprar bilhetes para o evento anteriormente selecionado
     */
    @FXML
	public void initialize() {
		System.out.println("CARREGADO");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("eventoID"));
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        diaColumn.setCellValueFactory(new PropertyValueFactory<>("dataHora"));
        precoBaseColumn.setCellValueFactory(new PropertyValueFactory<>("precoBase"));
		eventosTV.setItems(EventListDAO.getEventsLists());
      
		eventosTV.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal)-> {
			try {
				Main.createNewWindow("view/BuyTicketWindow.fxml", new BuyTicketController(newVal));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
    
    }
    

}

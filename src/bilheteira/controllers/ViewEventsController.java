package bilheteira.controllers;

import bilheteira.models.Event;
import bilheteira.models.DAO.EventListDAO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
   // private TableColumn<Event, Integer> lugaresDisponiveisColumn;
    
    private ObservableList<Event> eventos;
  
    @FXML
	public void initialize() {
		eventos = EventListDAO.getEventsLists();
		eventosTV.setItems(eventos);
	
        idColumn.setCellValueFactory(new PropertyValueFactory<>("eventoID"));
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        diaColumn.setCellValueFactory(new PropertyValueFactory<>("dia"));
        precoBaseColumn.setCellValueFactory(new PropertyValueFactory<>("precoBase"));
       // lugaresDisponiveisColumn.setCellValueFactory(new PropertyValueFactory<>("lugaresDisponiveis"));
	
        eventosTV.setOnMouseClicked(
        		(event)->{     
        		Event selectedEvent = eventosTV.getSelectionModel().getSelectedItem();          
        		
        });
	
    
    }
    }

package bilheteira.controllers;

import java.io.IOException;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class MainStageController {
	
	
	public void onViewEvents () {
		try {
			Main.createNewWindow("view/ViewEvents.fxml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onCreateEvent () {
		try {
			Main.createNewWindow("view/PasswordEvent.fxml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onRefound () {
		try {
			Main.createNewWindow("view/Refound.fxml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTicket () {
		try {
			Main.createNewWindow("view/ViewTicket.fxml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTicketTRY () {
		try {
			Main.createNewWindow("view/BuyTicketWindow.fxml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

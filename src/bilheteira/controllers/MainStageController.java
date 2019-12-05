package bilheteira.controllers;

import java.io.IOException;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;

public class MainStageController {

	@FXML
	PasswordField password;
	@FXML
	Button btnpassword;
	
	
	public void onCompraBilhete () {
		try {
			Main.createNewWindow("view/BuyTicketWindow.fxml");
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
}

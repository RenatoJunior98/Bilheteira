package bilheteira.controllers;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

public class PasswordEventController {

	@FXML
	Button enterButton;
	@FXML
	PasswordField password;
	
	public void onEnterButtonClicked () {
		try {
			if (password.getText().equals("admin")) {
			Main.getCurrentStage().close();
			Main.createNewWindow("view/CreateEvent.fxml");
			}
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}

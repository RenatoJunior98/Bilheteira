package application.view;

import java.io.IOException;

import application.Main;

public class MainStageController {
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
			Main.createNewWindow("view/CreateEvent.fxml");
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
}

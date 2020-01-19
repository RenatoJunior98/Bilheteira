package bilheteira.controllers;

import java.io.IOException;

import application.Main;

public class RefoundController {

	public void confirmarCodigo() {
		try {
			Main.createNewWindow("view/RefoundPreço.fxml", new RefoundController());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

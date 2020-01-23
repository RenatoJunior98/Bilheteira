package application;

import java.io.IOException;

import bilheteira.controllers.MainStageController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Classe Main do programa Contem os metodos da cria��o de janelas e o metodo
 * start da aplica��o
 * 
 * @author Ricardo Cruz and Renato J�nior
 *
 */
public class Main extends Application {

	private static Stage currentStage;

	/**
	 * M�todo Start da classe Main � o primeiro metodo chamado quando iniciada a
	 * aplica��o � criada a janela do MainStage Adiciona tamb�m um icon e o nome da
	 * aplica��o na borda da janela
	 */
	@Override
	public void start(Stage primaryStage) {
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("18216.png")));
		primaryStage.setTitle("Bilheteira");

		try {
			createNewWindow("view/MainStage.fxml", new MainStageController());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * M�todo da cria��o de novas janelas � chamado sempre que for necess�rio criar
	 * uma janela
	 * 
	 * @param fxmlLocation : localiza��o do FMXL
	 * @param controller   : controlador do FMXL
	 * @throws IOException : Sinais de que ocorreu algum tipo de uma IOException
	 */
	public static void createNewWindow(String fxmlLocation, Object controller) throws IOException {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxmlLocation));
		loader.setController(controller);
		Stage stage = new Stage();
		stage.getIcons().add(new Image(Main.class.getResourceAsStream("18216.png")));
		stage.setTitle("Bilheteira");
		Scene scene = new Scene(loader.load());
		scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
		currentStage = stage;
		stage.setScene(scene);
		stage.show();

	}

	/**
	 * Metodo getter da stage atual
	 * 
	 * @return stage atual
	 */
	public static Stage getCurrentStage() {
		return currentStage;
	}

}

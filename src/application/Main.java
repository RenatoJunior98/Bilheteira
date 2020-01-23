package application;

import java.io.IOException;

import bilheteira.controllers.MainStageController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Classe Main do programa Contem os metodos da criação de janelas e o metodo
 * start da aplicação
 * 
 * @author Ricardo Cruz and Renato Júnior
 *
 */
public class Main extends Application {

	private static Stage currentStage;

	/**
	 * Método Start da classe Main É o primeiro metodo chamado quando iniciada a
	 * aplicação É criada a janela do MainStage Adiciona também um icon e o nome da
	 * aplicação na borda da janela
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
	 * Método da criação de novas janelas É chamado sempre que for necessário criar
	 * uma janela
	 * 
	 * @param fxmlLocation : localização do FMXL
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

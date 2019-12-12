package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {
	
	
	private static Stage currentStage;
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("18216.png")));
		primaryStage.setTitle("Bilheteira");
		try {
			Pane root = FXMLLoader.load(getClass().getResource("view/MainStage.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			currentStage =primaryStage;
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static void createNewWindow (String fxmlLocation) throws IOException {
		Stage stage =  new Stage();
		stage.getIcons().add(new Image(Main.class.getResourceAsStream("18216.png")));
		stage.setTitle("Bilheteira");
		Pane root = FXMLLoader.load(Main.class.getResource(fxmlLocation));
		Scene scene = new Scene(root);
		currentStage = stage;
		stage.setScene(scene);
		stage.show();
		
	}

	
	public static Stage getCurrentStage() {
		return currentStage;
	}
	
	
}

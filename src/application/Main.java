package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		FXMLLoader rootFxml = new FXMLLoader();
		rootFxml.setLocation(this.getClass().getResource("ScreenView.fxml"));
		rootFxml.setController(new ScreenControl());
		
		Parent root = null;
		try {
			root = rootFxml.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(root);
		
		Stage stage = primaryStage;
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
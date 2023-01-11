package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenView {
	
	public static void showScreen(Stage stagePrimary) {
		FXMLLoader rootFxml = new FXMLLoader();
		rootFxml.setLocation(ScreenView.class.getResource("ScreenView.fxml"));
		rootFxml.setController(new ScreenControl());
		
		Parent root = null;
		try {
			root = rootFxml.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(root);
		
		Stage stage = stagePrimary;
		stage.setScene(scene);
		stage.show();
	}
}

package application;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent; // import Parent class


public class Main extends Application {
	
	private static Stage stg;
	@Override
	public void start(Stage primaryStage) {
		try {
			// Load the FXML file and initialize the root variable
			stg = primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root,800,600);
			URL cssPath = this.getClass().getResource("style.css");
			System.out.println("CSS File Path: " + cssPath);

			if (cssPath != null) {
			    String css = cssPath.toExternalForm();
			    scene.getStylesheets().add(css);
			} else {
			    System.out.println("The CSS file could not be found.");
			}
			primaryStage.setTitle("Sign in Page");
			primaryStage.setScene(scene); // Set the scene
			primaryStage.show(); // Show the stage
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeScene(String fxml) throws IOException{
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

package ihm;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("Lancement de l'application");
		
		 final URL fxmlURL = getClass().getResource("ressources/Jouer_tour(1)lancer_des.fxml");  // "ressources/Jouer_tour(1)lancer_des.fxml"
	     final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", Locale.FRANCE);
	     final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
	     Pane root = fxmlLoader.load();

		primaryStage.setTitle("Shadow Hunters");
		primaryStage.setScene(new Scene(root));
		primaryStage.centerOnScreen();
		primaryStage.show();
	}

	public static void main(String[] args) {

		String filepath = "src//ihm//ressources//musique//The_Red_Fox_Tavern.wav"; // lien vers la musique :
																					// https://www.youtube.com/watch?v=LBpKUIyOHdo
		Musique musiqueObjet = new Musique();
		//musiqueObjet.playMusique(filepath);
		launch(args);
	}
}

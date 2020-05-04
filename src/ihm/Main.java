package ihm;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.GestionnaireJeu;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		final URL fxmlURL = getClass().getResource("ressources/parametre.fxml");  // "ressources/Jouer_tour(1)lancer_des.fxml"
	    final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", Locale.FRANCE);
	    final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
	    Pane root = fxmlLoader.load();

		primaryStage.setTitle("Shadow Hunters");
		primaryStage.setScene(new Scene(root));
		primaryStage.centerOnScreen();
		primaryStage.setMaximized(true);
		primaryStage.show();
	}

	public static void main(String[] args) {
		System.err.close();
		GestionnaireJeu gj = GestionnaireJeu.getGestionnaireJeu();
		launch(args);
		
	}
}
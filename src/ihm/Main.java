package ihm;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import main.GestionnaireJeu;

public class Main extends Application {
	/*GraphicsDevice Gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int width = Gd.getDisplayMode().getWidth();
	int height = Gd.getDisplayMode().getHeight(); */

	@Override
	public void start(Stage primaryStage) throws Exception {
		final URL fxmlURL = getClass().getResource("ressources/Menu.fxml");
	    final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", Locale.FRANCE);
	    final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
	    Pane root = fxmlLoader.load();
	        
		primaryStage.setTitle("Shadow Hunters");
		primaryStage.setScene(new Scene(root));
		primaryStage.setMaximized(true);
		primaryStage.centerOnScreen();
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent arg0) {
		          System.exit(0);
			}
		});
		primaryStage.setMaximized(true);
		primaryStage.show();
	}

	public static void main(String[] args) {
		
		GestionnaireJeu gj = GestionnaireJeu.getGestionnaireJeu();
		/*
		RessourceLoader rl = new RessourceLoader();
		rl.loadRessources();
		gj.setRessourceLoader(rl);
		*/
		launch(args);
	}
}
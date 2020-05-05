package ihm.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

import carte.CarteLieu;
import ihm.SpriteAnimation;
import javafx.animation.Animation;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import main.Joueur;

public class JouerSonTour1Controller implements Initializable{
	@FXML private Pane rootPane;
	@FXML private Label d6;
	@FXML private Label d4;
	@FXML private Button btnStop;
	@FXML private Button btnLancer;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		btnStop.setVisible(false);
	}
	
	@FXML 
	public void lancerDes(MouseEvent mouseEvent)throws InterruptedException{
		System.out.println("\tLancements des dès");
		
		btnLancer.setVisible(false);
		btnStop.setVisible(true);
		
		for (int i=1; i<7; i++) {
			Thread.sleep(500);
			d6.setText(Integer.toString(i));
		}
		
		for (int i=1; i<5; i++) {
			Thread.sleep(500);
			d4.setText(Integer.toString(i));
		}
	}
	
	@FXML
	public void stop(MouseEvent mouseEvent) throws IOException, InterruptedException {
		Thread.sleep(2000);
		final URL fxmlURL = getClass().getResource("/ihm/ressources/Jouer_tour(2)carte_lieux.fxml");  
	    final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", Locale.ENGLISH);
	    final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
	    Pane root = fxmlLoader.load();
        rootPane.getChildren().setAll(root);
	}
}
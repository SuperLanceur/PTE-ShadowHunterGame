package ihm.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import carte.CarteLieu;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import main.Joueur;

public class JouerSonTour1Controller implements Initializable{
	private Joueur joueur;
	
	@FXML private Pane rootPane;
	@FXML private Label d6;
	@FXML private Label d4;
	@FXML private Label nomJoueur;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//nomJoueur.setText(joueur.getNom());
	}
	
	@FXML 
	public void lancerDes(MouseEvent mouseEvent) throws IOException, InterruptedException{
		//lancer d6
		int d6 = new Random().nextInt(6) + 1;
		this.d6.setText(Integer.toString(d6));
		
		//lancer d4
		int d4 = new Random().nextInt(4) + 1;
		this.d6.setText(Integer.toString(d4));
		
		Thread.sleep(1000);
		
		Pane pane = FXMLLoader.load(getClass().getResource("../ressources/Jouer_tour(2)carte_lieux.fxml"));
        rootPane.getChildren().setAll(pane);
	}
	
	public void deplacerPion(CarteLieu lieux) {
		
	}
}

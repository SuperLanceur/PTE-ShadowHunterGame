package ihm.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ihm.PopUp;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class PlateauController implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Affiche aux yeux de tous la carte personnage du joueur
	 * 
	 * @param mouseEvent : clique sur le bouton
	 * @throws IOException 
	 */
	public void seReveler(MouseEvent mouseEvent) throws IOException {
		System.out.println("Le joueur ... se revèle");
		Pane pane = FXMLLoader.load(getClass().getResource("../ressources/Reveler_son_identite.fxml"));
		PopUp popup = new PopUp(pane, "reveler son identité");
		popup.display();
	}
}

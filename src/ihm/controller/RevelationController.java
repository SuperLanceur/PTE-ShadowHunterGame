package ihm.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import main.Joueur;

public class RevelationController implements Initializable{
	
	@FXML private Label nomJoueur;
	@FXML private Label nomPerso;
	@FXML private Label factionPerso;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	
	public void showInformation(Joueur j) {
		nomJoueur.setText(j.getNom());
		//nomPerso.setText(j.getCartePersonnage().getNom());
		//factionPerso.setText(j.getCartePersonnage().getDescription());
	}
}
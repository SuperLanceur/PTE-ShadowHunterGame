package ihm.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import main.Joueur;

public class AfficherCarteController implements Initializable{
	
	@FXML private Label nom;
	@FXML private Label competence;
	@FXML private Pane root;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	
	public void showInformation(Joueur j) {
		//nom.setText(j.getCartePersonnage().getNom());
		//competence.setText(j.getCartePersonnage().getDescription());
	}
}
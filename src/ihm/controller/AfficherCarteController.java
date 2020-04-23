package ihm.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import main.Joueur;

public class AfficherCarteController implements Initializable{
	
	@FXML private Label nom;
	@FXML private Label competence;
	@FXML private Pane root;
	
	private Joueur joueur;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	
	public void showInformation(Joueur j) {
		this.joueur = j;
		nom.setText("???");
		competence.setText("???");
	}
	
	@FXML
	public void voirCarte(MouseEvent mouseEvent) {
		//nom.setText(joueur.getCartePersonnage().getNom());
		//competence.setText(joueur.getCartePersonnage().getDescription());
	}
}

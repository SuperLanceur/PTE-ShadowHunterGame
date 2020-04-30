package ihm.controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import main.Joueur;

public class JoueurIHM {

	private int position;
	private Joueur joueur;
	private Pane pane;
	
	public JoueurIHM(int i, Joueur joueur, Pane pane) {
		this.setPosition(i);
		this.setJoueur(joueur);
		this.pane = pane;
		
		String name = joueur.getNom();
		setLabelJoueur(name);
	}
	
	public Button getRevealButton() {
		Pane p = (Pane) pane.getChildren().get(1);
		return (Button) p.getChildren().get(1);
	}
	
	public ImageView getCartePersonnage() {
		Pane p = (Pane) pane.getChildren().get(1);
		return (ImageView) p.getChildren().get(0);
	}
	
	public AnchorPane getZoneJoueur() {
		return (AnchorPane) pane.getChildren().get(0);
	}
	
	public Label getLabelJoueur() {
		Pane p = (Pane) pane.getChildren().get(2);
		return (Label) p.getChildren().get(0);
	}
	
	public void setLabelJoueur(String name) {
		Label label = getLabelJoueur();
		label.setText(name);
	}
	
	public Label getPaneEquipement() {
		Pane p = (Pane) pane.getChildren().get(2);
		return (Label) p.getChildren().get(1);
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

}

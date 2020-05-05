package ihm.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ChoisirJoueur implements Initializable{
	@FXML private HBox joueurHaut;
	@FXML private HBox joueurBas;
	@FXML private Label titre;
	
	private int joueurSelected;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		for (int i=0; i<joueurHaut.getChildren().size(); i++) {
			int numJoueur = i;
			joueurHaut.getChildren().get(i).setOnMouseClicked(e -> {
				this.joueurSelected = numJoueur;
			});
		}
		
		for (int i=0; i<joueurBas.getChildren().size(); i++) {
			int numJoueur = i;
			joueurHaut.getChildren().get(i).setOnMouseClicked(e -> {
				this.joueurSelected = numJoueur;
			});
		}
	}

	//GETTERS AND SETTERS
	public HBox getJoueurHaut() {
		return joueurHaut;
	}

	public void setJoueurHaut(HBox joueurHaut) {
		this.joueurHaut = joueurHaut;
	}

	public HBox getJoueurBas() {
		return joueurBas;
	}

	public void setJoueurBas(HBox joueurBas) {
		this.joueurBas = joueurBas;
	}

	public Label getTitre() {
		return titre;
	}

	public void setTitre(Label titre) {
		this.titre = titre;
	}

	public int getJoueurSelected() {
		return joueurSelected;
	}

	public void setJoueurSelected(int joueurSelected) {
		this.joueurSelected = joueurSelected;
	}
}

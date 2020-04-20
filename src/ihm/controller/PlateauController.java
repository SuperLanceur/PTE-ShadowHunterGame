package ihm.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ihm.PopUp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import main.Joueur;

public class PlateauController implements Initializable {
	
	private List<Joueur> listJoueur = new ArrayList<Joueur>();
	private List<VBox> vboxJoueur = new ArrayList<VBox>();
	private List<Button> btnRevelation = new ArrayList<Button>();
	private List<Button> btnCartePerso = new ArrayList<Button>();
	private List<Label> nomPerso = new ArrayList<Label>();
	private List<Label> factionPerso = new ArrayList<Label>();
	
	@FXML private VBox joueur1;
	@FXML private VBox joueur2;
	@FXML private VBox joueur3;
	@FXML private VBox joueur4;
	@FXML private VBox joueur5;
	@FXML private VBox joueur6;
	@FXML private VBox joueur7;
	@FXML private VBox joueur8;


	/**
	 * attribuer les cartes
	 * ecrire le nom des joueurs au bon endroit 
	 * placer les cartes lieux
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// initialisation des joueurs
		attribuerPerso(listJoueur);
		
		//initialisation des attributs des joueurs
		this.vboxJoueur.add(joueur1);
		this.vboxJoueur.add(joueur2);
		this.vboxJoueur.add(joueur3);
		this.vboxJoueur.add(joueur4);
		this.vboxJoueur.add(joueur5);
		this.vboxJoueur.add(joueur6);
		this.vboxJoueur.add(joueur7);
		this.vboxJoueur.add(joueur8);
		for (VBox vbox : vboxJoueur) {
			nomPerso.add((Label) vbox.getChildren().get(1));
			factionPerso.add((Label) vbox.getChildren().get(0));
			HBox enfant = (HBox) vbox.getChildren().get(3);
			btnCartePerso.add((Button) enfant.getChildren().get(0));
			btnRevelation.add((Button) enfant.getChildren().get(1));
		}
		//initilaisation des boutons se reveler
		for (Button b : btnRevelation) {
			b.setOnAction(e -> {try {seReveler(null);} catch (IOException e1) {e1.printStackTrace();}});
		}
		//initialisation des bouton carte personnage
		for (Button b : btnCartePerso) {
			b.setOnAction(e -> {try {consulterSaCarte(null);} catch (IOException e1) {e1.printStackTrace();}});
		}
		//initialisation nom personnage
		for (Label l : nomPerso) {
			l.setText("???");
		}
		//initialisation nom personnage
		for (Label l : factionPerso) {
			l.setText("???");
		}
	}
	
	/**
	 * Affiche aux yeux de tous la carte personnage du joueur
	 * 
	 * @param mouseEvent : clique sur le bouton "Se reveler"
	 * @throws IOException 
	 */
	public void seReveler(Joueur j) throws IOException {
		System.out.println("Le joueur ... se revèle");
		Pane pane = FXMLLoader.load(getClass().getResource("../ressources/Reveler_son_identite.fxml"));
		PopUp popup = new PopUp(pane, "reveler son identité");
		popup.display();
	}
	
	/**
	 * Permet de consulter sa carte perssonage en cas d'oublie
	 * 
	 * @param mouseEvent : clique sur le bouton "Carte personnage"
	 * @throws IOException
	 */
	public void consulterSaCarte(Joueur j) throws IOException {
		System.out.println("Le joueur ... consulte sa carte");
		Pane pane = FXMLLoader.load(getClass().getResource("../ressources/afficher_carte_perso.fxml"));
		PopUp popup = new PopUp(pane, "Consulter sa carte");
		popup.display();
	}
	
	public void attribuerPerso(List<Joueur> lj) {
		
	}
}

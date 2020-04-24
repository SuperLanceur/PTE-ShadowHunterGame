package ihm.controller;


import java.io.IOException;
import java.net.URL;
import java.util.*;

import ihm.PopUp;
import ihm.PopUpBoolean;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.GestionnaireJeu;
import main.Joueur;
import main.View;

public class PlateauController implements Initializable {
	private List<Joueur> listJoueur = new ArrayList<Joueur>();
	private List<VBox> vboxJoueur = new ArrayList<VBox>();
	private List<Button> btnRevelation = new ArrayList<Button>();
	private List<Button> btnCartePerso = new ArrayList<Button>();
	private List<Label> nomPerso = new ArrayList<Label>();
	private List<Label> factionPerso = new ArrayList<Label>();
	private List<Label> nomJoueur = new ArrayList<Label>();
	
	@FXML private VBox joueur1;
	@FXML private VBox joueur2;
	@FXML private VBox joueur3;
	@FXML private VBox joueur4;
	@FXML private VBox joueur5;
	@FXML private VBox joueur6;
	@FXML private VBox joueur7;
	@FXML private VBox joueur8;
	
	/**
	 * initialise les donn�es du plateau
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
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
			nomJoueur.add((Label) vbox.getChildren().get(2));
			HBox enfant = (HBox) vbox.getChildren().get(3);
			btnCartePerso.add((Button) enfant.getChildren().get(0));
			btnRevelation.add((Button) enfant.getChildren().get(1));
		}
		//initilaisation des boutons se reveler
		int i = 0;
		for (Button b : btnRevelation) {
			int compteur = i;
			b.setOnAction(e -> {try {seReveler(compteur);} catch (IOException e1) {e1.printStackTrace();}});
			i++;
		}
		//initialisation des bouton carte personnage
		int j = 0;
		for (Button b : btnCartePerso) {
			int compteur = j;
			b.setOnAction(e -> {try {consulterSaCarte(compteur);} catch (IOException e1) {e1.printStackTrace();}});
			j++;
		}
		
		//initialisation nom personnage
		for (Label l : nomPerso) {
			l.setText("???");
		}
		//initialisation nom personnage
		for (Label l : factionPerso) {
			l.setText("???");
		}
		
		listJoueur = View.getJoueurs();
	}
	
	/**
	 * Affiche aux yeux de tous la carte personnage du joueur
	 * 
	 * @param j : Le joueur sur lequel on a cliqu�
	 */
	public void seReveler(int numJoueur) throws IOException {
		System.out.println(listJoueur.get(numJoueur).getNom() + " se revele");
		final URL fxmlURL = getClass().getResource("../ressources/Reveler_son_identite.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", Locale.FRANCE);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		Parent root = fxmlLoader.load();

        
        RevelationController rc = fxmlLoader.getController();
        rc.showInformation(listJoueur.get(numJoueur));
		
		PopUp popup = new PopUp(root, "Consulter sa carte");
		popup.display();
	}
	
	public boolean choisir(Joueur j) throws IOException {
		final URL fxmlURL = getClass().getResource("../ressources/choisirBoolean.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", Locale.FRANCE);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		Parent root = fxmlLoader.load();

        
		PopUpBoolean popup = new PopUpBoolean(root, "Consulter sa carte");
		return popup.display();
		
		
	}
	
	/**
	 * Permet de consulter sa carte perssonage en cas d'oublie
	 * 
	 * @param j : Le joueur sur lequel on a cliqu�
	 */
	public void consulterSaCarte(int numJoueur) throws IOException {
		System.out.println(listJoueur.get(numJoueur).getNom() + " consulte sa carte");
		final URL fxmlURL = getClass().getResource("../ressources/afficher_carte_perso.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", Locale.FRANCE);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		Parent root = fxmlLoader.load();

        
        AfficherCarteController acc = fxmlLoader.getController();
        acc.showInformation(listJoueur.get(numJoueur));
		
		PopUp popup = new PopUp(root, "Consulter sa carte");
		popup.display();
	}
	
	public void showInformation(Map<Integer, Joueur> j) {
		System.out.println("\tplacement des joueurs");
		
		for (int i=0; i<this.vboxJoueur.size(); i++) {
			if (j.get(i) != null)
				nomJoueur.get(i).setText(j.get(i).getNom());
			else {
				vboxJoueur.get(i).setVisible(false);
			}
		}
	}
}

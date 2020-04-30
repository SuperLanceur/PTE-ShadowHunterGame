package ihm.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import ihm.PopUp;
import ihm.PopUpBoolean;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import main.GestionnaireJeu;
import javafx.scene.shape.Circle;
import main.Joueur;

public class PlateauController implements Initializable {
	
	private List<Joueur> listJoueur = new ArrayList<Joueur>();
	private Map<Joueur,Pane> joueursPane;
	
	@FXML private AnchorPane rootPane;
	@FXML private HBox joueur1;
	@FXML private HBox joueur2;
	@FXML private HBox joueur3;
	@FXML private HBox joueur4;
	@FXML private VBox joueur5;
	@FXML private VBox joueur6;
	@FXML private VBox joueur7;
	@FXML private VBox joueur8;
	
	private List<VBox> vboxJoueur = new ArrayList<VBox>();
	private List<HBox> hboxJoueur = new ArrayList<HBox>();
	private List<Button> btnRevelation = new ArrayList<Button>();
	private List<ImageView> cartePerso = new ArrayList<ImageView>();
	private List<Label> nomJoueur = new ArrayList<Label>();
	private List<AnchorPane> tour = new ArrayList<AnchorPane>();
	
	@FXML private HBox lieux;
	@FXML private HBox vie;
	
	private List<Circle> pionLieux = new ArrayList<Circle>();
	private List<Circle> pionVie = new ArrayList<Circle>();
	
	public static int DICE_SIX = 2;
	public static int DICE_QUATRE = 1;
	public static int DICE_BOTH = 0;
	
	/**
	 * initialise les données du plateau
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Création du plateau ...");
		

		GestionnaireJeu gj  = GestionnaireJeu.getGestionnaireJeu();
	
		this.joueursPane = new HashMap<Joueur, Pane>();
		Map<Integer, Joueur> map = gj.getMapJoueurs();
	
		for(int i : map.keySet()) {
			this.joueursPane.put(map.get(i), getPaneJoueur(i));
		}
	
		System.out.println(joueursPane);
		
		this.hboxJoueur.add(joueur1);
		this.hboxJoueur.add(joueur2);
		this.hboxJoueur.add(joueur3);
		this.hboxJoueur.add(joueur4);
	
		for (HBox hbox : hboxJoueur) {
			tour.add((AnchorPane) hbox.getChildren().get(0));
			VBox carte = (VBox) hbox.getChildren().get(1);
			cartePerso.add((ImageView) carte.getChildren().get(0));
			btnRevelation.add((Button) carte.getChildren().get(1));
			VBox info = (VBox) hbox.getChildren().get(2);
			nomJoueur.add((Label) info.getChildren().get(0));
		}
		
		this.vboxJoueur.add(joueur5);
		this.vboxJoueur.add(joueur6);
		this.vboxJoueur.add(joueur7);
		this.vboxJoueur.add(joueur8);
		
		for (VBox vbox : vboxJoueur) {
			tour.add((AnchorPane) vbox.getChildren().get(0));
			HBox joueur = (HBox) vbox.getChildren().get(1);
			VBox carte = (VBox) joueur.getChildren().get(1);
			cartePerso.add((ImageView) carte.getChildren().get(0));
			btnRevelation.add((Button) carte.getChildren().get(1));
			VBox info = (VBox) joueur.getChildren().get(0);
			nomJoueur.add((Label) info.getChildren().get(0));
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
		for (ImageView b : cartePerso) {
			int compteur = j;
			b.setOnMouseClicked(e -> {try {consulterSaCarte(compteur);} catch (IOException e1) {e1.printStackTrace();}});
			j++;
		}
		
		
		//initialisation des pions
		VBox pionLieux14 = (VBox) lieux.getChildren().get(0);
		VBox pionLieux58 = (VBox) lieux.getChildren().get(4);
		for (int k=0; k<4; k++) {
			pionLieux.add((Circle) pionLieux14.getChildren().get(k));
		}
		for (int k=0; k<4; k++) {
			pionLieux.add((Circle) pionLieux58.getChildren().get(k));
		}
		
		VBox pionVie14 = (VBox) lieux.getChildren().get(0);
		VBox pionVie58 = (VBox) lieux.getChildren().get(4);
		for (int k=0; k<4; k++) {
			pionVie.add((Circle) pionVie14.getChildren().get(k));
		}
		for (int k=0; k<4; k++) {
			pionVie.add((Circle) pionVie58.getChildren().get(k));
		}
		
		System.out.println("Tour du joueur 1");

	    try {
	    	final URL fxmlURL = getClass().getResource("../ressources/Jouer_tour(1)lancer_des.fxml");  
		    final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", Locale.ENGLISH);
		    final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
			Pane root = fxmlLoader.load();
			root.setPrefSize(255, 180);
			tour.get(2).getChildren().setAll(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private Pane getPaneJoueur(int i) {	
		Pane parent = getPaneCoupleJoueurs(i);
		int position = i%2;
		return (Pane) parent.getChildren().get(position);
	}
	
	private Pane getPaneCoupleJoueurs(int i) {
		int position = (i%8)/2;
		Pane parent = (Pane) rootPane.getChildren().get(0);
		return (Pane) parent.getChildren().get(position+1);

	}
	
	/**
	 * Affiche aux yeux de tous la carte personnage du joueur
	 * 
	 * @param j : Le joueur sur lequel on a cliqué
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
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../ressources/choisirBoolean.fxml"));
		Parent root = loader.load();
        
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
	
	/**
	 * Place les joueurs au bon endroit sur le plateau
	 * 
	 * @param j : map donnant le joueur et son numero
	 */
	public void showInformation(Map<Integer, Joueur> j) {
		System.out.println("\tPlacement des joueurs");
		int taille = this.vboxJoueur.size() + this.hboxJoueur.size();
		
		for (int i=0; i<taille; i++) {
			if (j.get(i) != null)
				nomJoueur.get(i).setText(j.get(i).getNom());
			else {
				if (i < 4) {
					hboxJoueur.get(i).setVisible(false);
				}else {
					vboxJoueur.get(i-4).setVisible(false);
				}
				
			}
		}
	}

	public void rollDice(Joueur joueur, int typeDice, int[] rolls) {
		
		
		
	}

}
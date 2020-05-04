package ihm.controller;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import ihm.EffetSonore;
import ihm.PopUp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import main.GestionnaireJeu;
import main.Joueur;

public class PlateauController implements Initializable {
	
	private List<Joueur> listJoueur = new ArrayList<Joueur>();
	private List<JoueurIHM> joueursIHM;
	
	@FXML private AnchorPane rootPane;
	@FXML private GridPane gridPaneVie;
	@FXML public GridPane gridPaneLieux;
	
	private ChoisirBoolean cb;

	public static int DICE_SIX = 2;
	public static int DICE_QUATRE = 1;
	public static int DICE_BOTH = 0;
	
	/**
	 * initialise les données du plateau
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//System.out.println("Création du plateau ...");
		
		this.joueursIHM = new ArrayList<JoueurIHM>();
		GestionnaireJeu gj  = GestionnaireJeu.getGestionnaireJeu();
		Map<Integer, Joueur> map = gj.getMapJoueurs();
		
		for(int i = 0 ; i < gridPaneVie.getChildren().size();i++) {
		
			Pane p = (Pane) gridPaneVie.getChildren().get(i);
			Label l = (Label) p.getChildren().get(1);
			l.setText(i+"");
		}
	
		for(int i : map.keySet()) {
			System.out.println(i);
			joueursIHM.add(new JoueurIHM(i,map.get(i),getPaneJoueur(i),new Color(Math.random(), Math.random(), Math.random(),1),gridPaneVie, gridPaneLieux));
		}
		
		for(int i = 0; i<joueursIHM.size(); i++) {
			joueursIHM.get(i).deplacerPionVie((int) (Math.random()*13));
		}
		
		

		
		// BUTTONS ETC
		//System.out.println(this.joueursPane);
		
		/*
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
		}*/
	
		/*
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
		}*/
	
	}
	
	private Pane getPaneJoueur(int i) {	
		
		System.out.println("i "+i);
		int position = i%8;
		HBox hb = (HBox) rootPane.getChildren().get(0);		
		GridPane gp = null;
		
		// BAS
		 if(position < 2) {
			VBox group = (VBox) hb.getChildren().get(1);
			gp = (GridPane) group.getChildren().get(2);
		
			//DROITE
		 }else if(position < 4) {
			 System.out.println("Oui");
			 Group group = (Group) hb.getChildren().get(2);
			 gp = (GridPane) group.getChildren().get(0);
			 
			 //HAUT
		}else if(position < 6) {
			
			VBox group = (VBox) hb.getChildren().get(1);
			gp = (GridPane) group.getChildren().get(0);
			
			//GAUCHE
		}else if(position < 8) {
			Group group = (Group) hb.getChildren().get(0);
			gp = (GridPane) group.getChildren().get(0);
			
		}
		
		
		return (Pane) gp.getChildren().get(i%2);
	}
	
	/**
	 * Affiche aux yeux de tous la carte personnage du joueur
	 * 
	 * @param j : Le joueur sur lequel on a cliqué
	 */
	public void seReveler(int numJoueur) throws IOException {
		System.out.println(listJoueur.get(numJoueur).getNom() + " se revele");
		final URL fxmlURL = getClass().getResource("/ihm/ressources/Reveler_son_identite.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", Locale.FRANCE);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		Parent root = fxmlLoader.load();
        
        RevelationController rc = fxmlLoader.getController();
        rc.showInformation(listJoueur.get(numJoueur));
		
		PopUp popup = new PopUp(root, "Consulter sa carte");
		popup.display();
	}
	
	
	
	public JoueurIHM getJoueurIHM(Joueur j) {
		
		for(JoueurIHM joueurIHM : joueursIHM) {
			if(joueurIHM.getJoueur().equals(j)) return joueurIHM;
		}
		
		return null;
	}
	
	
	/**
	 * Permet de consulter sa carte perssonage en cas d'oublie
	 * 
	 * @param j : Le joueur sur lequel on a cliqu�
	 */
	public void consulterSaCarte(int numJoueur) throws IOException {
		System.out.println(listJoueur.get(numJoueur).getNom() + " consulte sa carte");
		final URL fxmlURL = getClass().getResource("/ihm/ressources/afficher_carte_perso.fxml");
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
	public void placerJoueurs(Map<Integer, Joueur> j) {
		Set<Integer> set = j.keySet();
		
		for(int i = 0; i < 8; i++) {
			if(!set.contains(i)) {
				getPaneJoueur(i).getChildren().setAll();
			}
		}
		
	}

	public void rollDice(Joueur joueur, int typeDice, int[] rolls) {
		
		
		
	}

	public void afficherChoisir(Joueur j) throws IOException {
		final URL fxmlURL = getClass().getResource("/ihm/ressources/choisirBoolean.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", Locale.FRANCE);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		Pane root = (Pane)fxmlLoader.load();
		this.cb = fxmlLoader.getController();
		JoueurIHM jihm = getJoueurIHM(j);
		jihm.setZoneJoueur(root);
	}

	public boolean getChoix(Joueur joueur) {
		JoueurIHM jihm = getJoueurIHM(joueur);
		boolean result = this.cb.getResult();
		this.cb = null;
		jihm.getZoneJoueur().getChildren().setAll();
		return result;
	}

	public void deplacer(Joueur currentJoueur) {
		JoueurIHM jIHM = getJoueurIHM(currentJoueur);
		jIHM.replacerPionLieu();
		
	}

	public void updateVieJoueur(Joueur joueur, int damage) {
		/*JoueurIHM jIHM = getJoueurIHM(joueur);
		jIHM.deplacerPionVie(damage);*/
		
	}
	
	@FXML
	public void mettreEnPause(MouseEvent me) throws IOException {
		
		InputStream fileSound1 =  getClass().getResourceAsStream("/ihm/ressources/musique/BEEP1.wav");
		EffetSonore.playSoundEffect(fileSound1);
		
		System.out.println("Jeu en pause ...");
		final URL fxmlURL = getClass().getResource("../ressources/Pause.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", Locale.FRANCE);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		Pane root = (Pane)fxmlLoader.load();
		
		PopUp pu = new PopUp(root, "Pause");
		pu.display();
	}
}
package ihm.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import ihm.PopUp;
import ihm.PopUpBoolean;
import ihm.SpriteAnimation;
import javafx.animation.Animation;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import main.Joueur;

public class PlateauControllerTest implements Initializable {
	private List<Joueur> listJoueur = new ArrayList<Joueur>();
	private List<VBox> vboxJoueur = new ArrayList<VBox>();
	private List<Button> btnRevelation = new ArrayList<Button>();
	private List<Button> btnCartePerso = new ArrayList<Button>();
	private List<Label> nomPerso = new ArrayList<Label>();
	private List<Label> factionPerso = new ArrayList<Label>();
	private List<Label> nomJoueur = new ArrayList<Label>();
	
	
	@FXML private AnchorPane anchorPane1;
	@FXML private AnchorPane anchorPane2;
	@FXML private AnchorPane anchorPane3;
	@FXML private AnchorPane anchorPane4;
	@FXML private AnchorPane anchorPane5;
	@FXML private AnchorPane anchorPane6;
	@FXML private AnchorPane anchorPane7;
	@FXML private AnchorPane anchorPane8;

	/**
	 * initialise les donn�es du plateau
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//initialisation des attributs des joueurs
		
	
		int OFFSET_X = 0;
		int OFFSET_Y = 0;
		int WIDTH = 557;
		int HEIGHT = 557;
		int COUNT = 6;
		int COLUMNS = 6;
	
		//anchorPane1.getChildren().setAll(imageView);
		
		
		ImageView imageView;
		try {
			imageView = FXMLLoader.load(getClass().getResource("../ressources/Dés.fxml"));
			imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));

			imageView.fitWidthProperty().bind(anchorPane1.widthProperty()); 
			final SpriteAnimation animation = new SpriteAnimation(
			        imageView,
			        Duration.millis(250),
			        COUNT, COLUMNS,
			        OFFSET_X, OFFSET_Y,
			        WIDTH, HEIGHT
			);
			animation.setCycleCount(Animation.INDEFINITE);
			animation.play();
			anchorPane1.getChildren().addAll(new Group(imageView));
			anchorPane1.setOnMousePressed(new EventHandler<Event>(
					
					) {

						@Override
						public void handle(Event arg0) {
							animation.stop();
						
						}
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Affiche aux yeux de tous la carte personnage du joueur
	 * 
	 * @param j : Le joueur sur lequel on a cliqu�
	 */
	public void seReveler(int numJoueur) throws IOException {
		System.out.println(listJoueur.get(numJoueur).getNom() + " se revele");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../ressources/Reveler_son_identite.fxml"));
		Parent root = loader.load();
        
        RevelationController rc = loader.getController();
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
	
	public void rollDice(Joueur j, int typeDice, int[] resultats) {
		
	}
	
	/**
	 * Permet de consulter sa carte perssonage en cas d'oublie
	 * 
	 * @param j : Le joueur sur lequel on a cliqu�
	 */
	public void consulterSaCarte(int numJoueur) throws IOException {
		System.out.println(listJoueur.get(numJoueur).getNom() + " consulte sa carte");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../ressources/afficher_carte_perso.fxml"));
		Parent root = loader.load();
        
        AfficherCarteController acc = loader.getController();
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

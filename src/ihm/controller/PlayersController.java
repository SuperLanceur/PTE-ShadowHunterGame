package ihm.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import main.Joueur;
import main.JoueurVirtuel;
import main.View;

public class PlayersController implements Initializable{

	@FXML private BorderPane rootPane;
	
	@FXML private HBox hb1;
	@FXML private HBox hb2;
	@FXML private HBox hb3;
	@FXML private HBox hb4;
	@FXML private HBox hb5;
	@FXML private HBox hb6;
	@FXML private HBox hb7;
	@FXML private HBox hb8;
	
	private List<HBox> ligne = new ArrayList<HBox>();
	private List<Button> plus = new ArrayList<Button>();
	private List<TextField> txt = new ArrayList<TextField>();
	private List<CheckBox> ia = new ArrayList<CheckBox>();
	
	private List<Joueur> joueurs = new ArrayList<Joueur>();

	
	/**
	 * recup�re chaque bouton textField et Checkebox a partir des hbox 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ligne.add(hb1);
		ligne.add(hb2);
		ligne.add(hb3);
		ligne.add(hb4);
		ligne.add(hb5);
		ligne.add(hb6);
		ligne.add(hb7);
		ligne.add(hb8);
		for (HBox hb : ligne) {
			txt.add((TextField) hb.getChildren().get(0));
			plus.add((Button) hb.getChildren().get(1));
			ia.add((CheckBox) hb.getChildren().get(2));
		}
		
		int i=0;
		for (Button btn : plus) {
			int compteur = i;
				btn.setOnAction(e -> {ajoutJoueur(compteur);});
			i++;
		}
		
		for (TextField tf : txt) {
			tf.setEditable(false);
			tf.setStyle("-fx-background-color: silver;");
		}
	}
	
		
	@FXML
	public void commencerJeux(MouseEvent mouseEvent) throws IOException{
		//ajout des joueurs finalement selectionner
		int nbJoueurs = 0;
				
		for (HBox hb : ligne) {
			
			TextField tf = (TextField) hb.getChildren().get(0);
			CheckBox cb = (CheckBox) hb.getChildren().get(2);
			Joueur j;
			
			if (tf.isEditable()) {
				if(cb.isSelected()) {
					joueurs.add(new Joueur(tf.getText()));
				}
				else {
					joueurs.add(new JoueurVirtuel(tf.getText()));
				}
				joueurs.add(null);
				nbJoueurs++;	
			}
			
		}
		
		if (nbJoueurs < 4) {
			Alert alert = new Alert(AlertType.WARNING, "Il faut au moins de 4 joueurs !");
	        alert.showAndWait();
		}else {
			System.out.println("Lancement du jeu...");
			View.initPartie(joueurs);
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ressources/Plateau.fxml"));
	        Parent root = loader.load();
	        
	        PlateauController pc = loader.getController();
	        pc.showInformation(joueurs);
	        
	        rootPane.getChildren().setAll(root);
		}
	}
	
	
	
	/**
	 * Autorise a �crire dans le text filed le nom du joueur ajouter
	 * 
	 * @param indice : pour savoir quel bouton a �t� cliqu�
	 */
	public void ajoutJoueur(int indice){
		System.out.println("Ajout du joueur " + (indice+1));
		plus.get(indice).setText("- ");
		txt.get(indice).setEditable(true);
		txt.get(indice).setStyle("-fx-background-color: white;");
		plus.get(indice).setOnAction(e -> {enleverJoueur(indice);});
	}
	
	/**
	 * Retire le joueur précedemnt ajouter
	 * 
	 * @param indice : pour savoir quel bouton a �t� cliqu�
	 */
	public void enleverJoueur(int indice) {
		System.out.println("Desistement du joueur " + (indice+1));
		plus.get(indice).setText("+");
		txt.get(indice).setEditable(false);
		txt.get(indice).setText("");
		txt.get(indice).setStyle("-fx-background-color: silver;");
		plus.get(indice).setOnAction(e -> {ajoutJoueur(indice);});
	}
}

package ihm.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import ihm.Couple;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import main.Configuration;
import main.GestionnaireJeu;
import main.Joueur;

public class PlayersController implements Initializable{

	@FXML private AnchorPane rootPane;
	@FXML private Button btnCommencer;
	
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
	
	private HashMap<Integer, Couple> joueurs = new HashMap<Integer, Couple>();
	
	private int nbJoueursH = 0;
	private int nbJoueursV = 0;

	
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
		
		int j=0;
		for (CheckBox cb : ia) {
			int compteur = j;
			cb.setOnAction(e -> {mettreNomDefaut(compteur);});
			j++;
		}
		
		btnCommencer.setStyle("-fx-background-color: gray; -fx-text-fill: black;");
	}
	
		
	@FXML
	public void commencerJeux(MouseEvent mouseEvent) throws IOException{
		if (nbJoueursH + nbJoueursV >= 4) {
			//ajout des joueurs finalement selectionner
			int i = 0;
			for (HBox hb : ligne) {
				TextField tf = (TextField) hb.getChildren().get(0);
				CheckBox cb = (CheckBox) hb.getChildren().get(2);
				if (tf.isEditable()) {
					if(cb.isSelected()) {
						joueurs.put(i, new Couple(tf.getText(), true));
					}
					else {
						joueurs.put(i, new Couple(tf.getText(), false));
					}
				}
				i++;
			}
				// Creer une configuration
				//View.applyConfiguration(new Configuration(joueurs, nbJoueursV, nbJoueursH));
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../ressources/Plateau.fxml"));
		        Parent root = loader.load();
		        
		        
		        PlateauController pc = loader.getController();
		        GestionnaireJeu.setPlateauController(pc);
		        GestionnaireJeu.setConfiguration(new Configuration(this.joueurs));
		        Map<Integer, Joueur> map = GestionnaireJeu.getJoueursMap(new Configuration(this.joueurs));
		        
		        
		        pc.showInformation(map);
		        Scene scene = new Scene(root);
		        Stage appStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
		        appStage.setScene(scene);
		        appStage.show();
		        GestionnaireJeu.lancerPartie();
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
		
		if (ia.get(indice).isSelected()) {
			nbJoueursV++;
		}else 
			nbJoueursH++;
		
		if (nbJoueursH + nbJoueursV >= 4) {
			btnCommencer.setStyle("-fx-background-color: #1d1d1d; -fx-text-fill: #d8d8d8;");
		}
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
		
		if (ia.get(indice).isSelected())
			nbJoueursV--;
		else 
			nbJoueursH--;
		
		if (nbJoueursH + nbJoueursV < 4) {
			btnCommencer.setStyle("-fx-background-color: gray; -fx-text-fill: black;");
		}
	}
	
	public void mettreNomDefaut(int indice) {
		if (ia.get(indice).isSelected()) {
			ajoutJoueur(indice);
			txt.get(indice).setText("Joueur" + indice);
		}else 
			enleverJoueur(indice);
	}
}

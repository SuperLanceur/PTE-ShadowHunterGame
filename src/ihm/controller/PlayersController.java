package ihm.controller;

import java.io.IOException;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import ihm.Couple;
import ihm.EffetSonore;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.Configuration;
import main.GestionnaireJeu;
import main.Joueur;
import sun.util.resources.Bundles;

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
	
	//pour les radios boutons
	@FXML private HBox hbr1;
	@FXML private HBox hbr2;
	@FXML private HBox hbr3;
	@FXML private HBox hbr4;
	@FXML private HBox hbr5;
	@FXML private HBox hbr6;
	@FXML private HBox hbr7;
	@FXML private HBox hbr8;
	
	
	@FXML private ToggleGroup tg1;
	@FXML private ToggleGroup tg2;
	@FXML private ToggleGroup tg3;
	@FXML private ToggleGroup tg4;
	@FXML private ToggleGroup tg5;
	@FXML private ToggleGroup tg6;
	@FXML private ToggleGroup tg7;
	@FXML private ToggleGroup tg8;
	
	
	private List<HBox> ligne = new ArrayList<HBox>();
	private List<Button> plus = new ArrayList<Button>();
	private List<TextField> txt = new ArrayList<TextField>();
	private List<CheckBox> ia = new ArrayList<CheckBox>();
	
	private List<HBox> listeHbIA = new ArrayList<HBox>();
	private List<RadioButton> listeIaLv1 = new ArrayList<RadioButton>();
	private List<RadioButton> listeIaLv2 = new ArrayList<RadioButton>();
	private List<RadioButton> listeIaLv3 = new ArrayList<RadioButton>();

	private List<ToggleGroup> listeToggleRbIa = new ArrayList<ToggleGroup>();
	
	
	private HashMap<Integer, Couple> joueurs = new HashMap<Integer, Couple>();
	private ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", ParametreController.LaLangue);
	
	private int nbJoueursH = 0;
	private int nbJoueursV = 0;
		
	/**
	 * recupère chaque bouton textField et Checkebox à partir des hbox 
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
		

		listeHbIA.add(hbr1);
		listeHbIA.add(hbr2);
		listeHbIA.add(hbr3);
		listeHbIA.add(hbr4);
		listeHbIA.add(hbr5);
		listeHbIA.add(hbr6);
		listeHbIA.add(hbr7);
		listeHbIA.add(hbr8);
		
		
		listeToggleRbIa.add(tg1);
		listeToggleRbIa.add(tg2);
		listeToggleRbIa.add(tg3);
		listeToggleRbIa.add(tg4);
		listeToggleRbIa.add(tg5);
		listeToggleRbIa.add(tg6);
		listeToggleRbIa.add(tg7);
		listeToggleRbIa.add(tg8);
		
		
		for (HBox hb : ligne) {
			txt.add((TextField) hb.getChildren().get(0));
			plus.add((Button) hb.getChildren().get(1));
			ia.add((CheckBox) hb.getChildren().get(2));
		}
		
		for (HBox hbr : listeHbIA) {
			listeIaLv1.add((RadioButton) hbr.getChildren().get(0));
			listeIaLv2.add((RadioButton) hbr.getChildren().get(1));
			listeIaLv3.add((RadioButton) hbr.getChildren().get(2));
			
			hbr.getChildren().get(0).setVisible(false);
			hbr.getChildren().get(1).setVisible(false);
			hbr.getChildren().get(2).setVisible(false);
		}
		
		int i=0;
		for (Button btn : plus) {
			int compteur = i;
			btn.setOnAction(e -> {
				ajoutJoueur(compteur);});
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
			
			if(textVide()==false && memeNom()==false) {
				
			//ajout des joueurs finalement selectionner
			int i = 0;
			for (HBox hb : ligne) {
				TextField tf = (TextField) hb.getChildren().get(0);
				CheckBox cb = (CheckBox) hb.getChildren().get(2);
				if (tf.isEditable()) {
					if(cb.isSelected()) {
						joueurs.put(i, new Couple(tf.getText(), choixDifficulte(listeToggleRbIa.get(i))));
					}
					else {
						joueurs.put(i, new Couple(tf.getText()));
					}
				}
				i++;
			}
				// Creer une configuration
				//View.applyConfiguration(new Configuration(joueurs, nbJoueursV, nbJoueursH));
				
				InputStream fileSound1 =  getClass().getResourceAsStream("/ihm/ressources/musique/BEEP1.wav");
				EffetSonore.playSoundEffect(fileSound1);
				
				System.out.println(this.joueurs);
				GestionnaireJeu gj = GestionnaireJeu.getGestionnaireJeu();
		        gj.setConfiguration(new Configuration(this.joueurs));
			
				final URL fxmlURL = getClass().getResource("/ihm/ressources/PlateauTest2.fxml");
				final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", ParametreController.LaLangue);
				final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
				AnchorPane root = fxmlLoader.load();
				PlateauController pc = fxmlLoader.getController();
				
				gj.setPlateauController(pc);
		       
		        Map<Integer, Joueur> map = gj.getMapJoueurs();
		        
		        
		        pc.placerJoueurs(map);
		        Scene scene = new Scene(root);
		        Stage appStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
		        appStage.setScene(scene);
		        appStage.show();
		        gj.lancerPartie();
		}
		else {
			System.out.println("On ne peut pas prendre un nom vide ou prendre le même nom qu'un autre joueur");
			
		}
		}
		
		else {
		InputStream fileSound2 =  getClass().getResourceAsStream("/ihm/ressources/musique/BeepError.wav");
		EffetSonore.playSoundEffect(fileSound2);
		System.out.println(bundle.getString("manque.joueur"));
		}
	}
	
	
	
	/**
	 * Autorise a �crire dans le text filed le nom du joueur ajouter
	 * 
	 * @param indice : pour savoir quel bouton a �t� cliqu�
	 */
	public void ajoutJoueur(int indice){
		System.out.println(bundle.getString("ajout.joueur") + (indice+1));
		
		InputStream fileSound3 =  getClass().getResourceAsStream("/ihm/ressources/musique/Beep2.wav");
		EffetSonore.playSoundEffect(fileSound3);
		
		plus.get(indice).setText("-");
		txt.get(indice).setEditable(true);
		txt.get(indice).setStyle("-fx-background-color: white;");
		plus.get(indice).setOnAction(e -> {enleverJoueur(indice);});
		
		if (ia.get(indice).isSelected()) {
			
			listeIaLv1.get(indice).setVisible(true);
			listeIaLv2.get(indice).setVisible(true);
			listeIaLv3.get(indice).setVisible(true);
			
			plus.get(indice).setDisable(true);
			
			nbJoueursV++;
		}else {
			ia.get(indice).setVisible(false);
			nbJoueursH++;
		}
		
		if (nbJoueursH + nbJoueursV >= 4 && memeNom()==false && textVide()==false) {
			btnCommencer.setStyle("-fx-background-color: #1d1d1d; -fx-text-fill: #d8d8d8;");
		}
	}
	
	/**
	 * Retire le joueur précedemnt ajouter
	 * 
	 * @param indice : pour savoir quel bouton a �t� cliqu�
	 */
	public void enleverJoueur(int indice) {
		System.out.println(bundle.getString("desistement") + (indice+1));
		
		InputStream fileSound3 =  getClass().getResourceAsStream("/ihm/ressources/musique/Beep2.wav");
		EffetSonore.playSoundEffect(fileSound3);
		
		plus.get(indice).setText("+");
		txt.get(indice).setEditable(false);
		txt.get(indice).setText("");
		txt.get(indice).setStyle("-fx-background-color: silver;");
		plus.get(indice).setOnAction(e -> {ajoutJoueur(indice);});
		
		if (ia.get(indice).isSelected()) {
			nbJoueursV--;
		}
			
		else {
			nbJoueursH--;
		}
		
		ia.get(indice).setVisible(true);
		plus.get(indice).setDisable(false);
		listeIaLv1.get(indice).setVisible(false);
		listeIaLv2.get(indice).setVisible(false);
		listeIaLv3.get(indice).setVisible(false);
		
		
		if (nbJoueursH + nbJoueursV < 4) {
			btnCommencer.setStyle("-fx-background-color: gray; -fx-text-fill: black;");
		}
	}
	
	public int choixDifficulte(ToggleGroup tog) {
		if(tog.getSelectedToggle() == tog.getToggles().get(0)) {
			System.out.println(bundle.getString("ia.facile"));
			return 1;
		}
		
		else if (tog.getSelectedToggle() == tog.getToggles().get(1)) {
			System.out.println(bundle.getString("ia.moyenne"));
			return 2;
		}
		
		else if (tog.getSelectedToggle() == tog.getToggles().get(2)) {
			System.out.println(bundle.getString("ia.difficile"));
			return 3;
		}
		
		else {
			System.out.println(bundle.getString("erreur.difficulte"));
			return -1;
		}
	}
	
	public void mettreNomDefaut(int indice) {
		if (ia.get(indice).isSelected()) {
			txt.get(indice).setText("Joueur" + indice);

			ajoutJoueur(indice);
		}else 
			enleverJoueur(indice);
	}
	public boolean textVide() {
		for(int i=0;i<txt.size();i++) {
			if(txt.get(i).isEditable() && txt.get(i).getText().equals("") || txt.get(i).isEditable() && txt.get(i).getText().isBlank()) {
				return true;
			}
		}
		return false;
	}
	@FXML
	public void couleurBtnCommencerJeu() {
		
		
		

		if (nbJoueursH + nbJoueursV >= 4 && memeNom()==false && textVide()==false) {
		btnCommencer.setStyle("-fx-background-color: #1d1d1d; -fx-text-fill: #d8d8d8;");
		}
		else
		{
			btnCommencer.setStyle("-fx-background-color: gray; -fx-text-fill: black;");

		}
			
		
	}
	public boolean memeNom() {
		
		int i=0;
		

		while(i<txt.size()) {
			
			for(int j=0;j<txt.size();j++) {
				
				

				if(txt.get(i).getText().equals(txt.get(j).getText()) && txt.get(i).isEditable() && txt.get(j).isEditable() && !(j==i)){
					
					return true;
				}
				
			}
			i++;
			
		}
		return false;
	}
/*	public boolean nomAutorise() {
	
		int i=0;
		while(i<txt.size()) {
			if(txt.get(i).isEditable() && txt.get(i).getText().isBlank()) {
				return false;
			}
			i++;
		}
		
		return true;

	}*/
	@FXML
	public void retour(MouseEvent me) throws IOException {
		InputStream fileSound1 =  getClass().getResourceAsStream("/ihm/ressources/musique/BEEP1.wav");
		EffetSonore.playSoundEffect(fileSound1);
		
		 final URL fxmlURL = getClass().getResource("/ihm/ressources/Menu.fxml");
			final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", ParametreController.LaLangue);
			
			final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
			Pane pane = fxmlLoader.load();

	        rootPane.getChildren().setAll(pane);
		}
}

package ihm.controller;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ihm.EffetSonore;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.Joueur;

public class FinDePartieControlleur implements Initializable {
	
	@FXML private Pane rootPane;	
	@FXML private Label labelWinner;
	@FXML private VBox vbListeWinner;

	public static List<Joueur> listeWinner = new ArrayList<Joueur>();
	//public static List<Image> listeImageCarte = new ArrayList<Image>(); 

	
	/*
	//initialise pour faire des test (a supprimer)
	private Joueur j1 = new Joueur("Joueur1");
	private Joueur j2 = new Joueur("Joueur2");
	private Joueur j3 = new Joueur("Joueur3");
	private Joueur j4 = new Joueur("Joueur4");
	private Joueur j5 = new Joueur("Joueur5");
	private Joueur j6 = new Joueur("Joueur6");
*/
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		/*
		//initialise pour faire des test (a supprimer)
		listeWinner.add(j1);
		listeWinner.add(j2);
		listeWinner.add(j3);
		listeWinner.add(j4);
		listeWinner.add(j5);
		listeWinner.add(j6);
		
		
		listeImageCarte.add(PlateauController.getImageDosCarte(RessourceLoader.DOS_LUMIERE));
		listeImageCarte.add(PlateauController.getImageDosCarte(RessourceLoader.CARTES_TENEBRE));
		listeImageCarte.add(PlateauController.getImageDosCarte(RessourceLoader.DOS_VISION));
		*/
		
		
		for(int i = 0 ; i<listeWinner.size(); i++) {
			
			HBox JVainqueur = new HBox();
			JVainqueur.setAlignment(Pos.CENTER);

			/*
			//pour mettre une image de la carte perso du joueur : 
			ImageView ivJoueur = new ImageView();
			Image im = listeImageCarte.get(i);
			ivJoueur.setImage(im);
			JVainqueur.getChildren().add(ivJoueur);
			*/
			Label nomJoueurGagant = new Label();
			nomJoueurGagant.setText(listeWinner.get(i).getNom() + "qui était "+ listeWinner.get(i).getCartePersonnage().getNom() + " ("+listeWinner.get(i).getCartePersonnage().getEquipe()+ ")");
			nomJoueurGagant.setFont(new Font("Arial", 36));
			nomJoueurGagant.setStyle("-fx-text-fill: white");
			JVainqueur.getChildren().add(nomJoueurGagant);

			vbListeWinner.getChildren().add(JVainqueur);
		}
		
		vbListeWinner.setSpacing(30);
		

	}

	@FXML
	public void retourMenu(MouseEvent mouseEvent) throws IOException {

		InputStream fileSound1 = getClass().getResourceAsStream("/ihm/ressources/musique/BEEP1.wav");

		EffetSonore.playSoundEffect(fileSound1);
		System.out.println("Retour au Menu");
		final URL fxmlURL = getClass().getResource("/ihm/ressources/Menu.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", ParametreController.LaLangue);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		AnchorPane pane = fxmlLoader.load();
		Scene scene = new Scene(pane);
		Stage appStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
		appStage.setScene(scene);
		appStage.show();

	}

	public List<Joueur> getListeWinner() {
		return listeWinner;
	}

	public void setListeWinner(List<Joueur> listeWinner) {
		FinDePartieControlleur.listeWinner = listeWinner;
	}

	/*
	public static List<Image> getListeImageCarte() {
		return listeImageCarte;
	}

	public static void setListeImageCarte(List<Image> listeImageCarte) {
		FinDePartieControlleur.listeImageCarte = listeImageCarte;
	}
	
	*/
	
	
	
	
}

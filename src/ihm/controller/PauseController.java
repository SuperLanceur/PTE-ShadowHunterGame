package ihm.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import ihm.EffetSonore;
import ihm.Musique;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.GestionnaireJeu;
import main.Joueur;

public class PauseController implements Initializable {
	@FXML
	private CheckBox cbMusique;
	@FXML
	private CheckBox cbEffet;

	String filepathMusique = "src//ihm//ressources//musique//The_Red_Fox_Tavern.wav";
	InputStream fileMusique = getClass().getResourceAsStream("/ihm/ressources/musique/The_Red_Fox_Tavern.wav");

	boolean MusiqueLancee = ParametreController.cbMusiqueCoche;
	boolean SonLance = ParametreController.cbSonCoche;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		if (MusiqueLancee == true) {
			cbMusique.setSelected(true);
		}

		if (SonLance == true) {
			cbEffet.setSelected(true);
		}

	}

	@FXML
	public void reprendre(MouseEvent me) {
		InputStream fileSound1 = getClass().getResourceAsStream("/ihm/ressources/musique/BEEP1.wav");

		// Pour la musique

		if (fileMusique != null) {
			if (cbMusique.isSelected()) {
				System.out.println("\tLancement de la musique");
				
				if (Musique.clipTimePosition == 0 && MusiqueLancee == false) { // si la musique n'a jamais été lancé
					Musique.playMusique(fileMusique);
					MusiqueLancee = true;
				} else
					Musique.resumeMusique(Musique.clip); // si elle a deja été lancé mais mis en pause, reprend a partir du point d'arret									
			} else {
				Musique.pauseMusique(Musique.clip); // met en pause la musique
				System.out.println("\tMise en pause de la musique");
			}
		}
		else {
			System.out.println("fichier audio non trouvé");
		}

		// Pour les effets sonores
		if (cbEffet.isSelected() == true) {
			System.out.println("\tEffets sonores activé");
			EffetSonore.setSoundOK(true);

		} else {
			System.out.println("\tEffets sonores désactivé");
			EffetSonore.setSoundOK(false);
		}

		ParametreController.cbSonCoche = cbEffet.isSelected();
		ParametreController.cbMusiqueCoche = cbMusique.isSelected();

		EffetSonore.playSoundEffect(fileSound1); // met un bruit sur le bouton si les effets sonores sont activés

		System.out.println("Retour au jeu");
		Stage appStage = (Stage) ((Node) me.getSource()).getScene().getWindow();
		appStage.close();
	}

	@FXML
	public void quitter(MouseEvent me) throws IOException {
		InputStream fileSound1 = getClass().getResourceAsStream("/ihm/ressources/musique/BEEP1.wav");
		EffetSonore.playSoundEffect(fileSound1);
		GestionnaireJeu.endGame();
		System.err.println("Fin de partie");
		Stage appStage = (Stage) ((Node) me.getSource()).getScene().getWindow();
		appStage.close();
		
		final URL fxmlURL = getClass().getResource("/ihm/ressources/Menu.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", Locale.FRENCH);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		AnchorPane root = fxmlLoader.load();
        
		
	}
}

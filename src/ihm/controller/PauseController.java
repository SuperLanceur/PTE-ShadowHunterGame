package ihm.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import ihm.EffetSonore;
import ihm.Musique;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.GestionnaireJeu;

public class PauseController implements Initializable {
	@FXML
	private CheckBox cbMusique;
	@FXML
	private CheckBox cbEffet;
	@FXML
	private Slider sliderMusiquePause;

	String filepathMusique = "src//ihm//ressources//musique//The_Red_Fox_Tavern.wav";
	InputStream fileMusique = getClass().getResourceAsStream("/ihm/ressources/musique/The_Red_Fox_Tavern.wav");

	boolean MusiqueLancee = ParametreController.cbMusiqueCoche;
	boolean SonLance = ParametreController.cbSonCoche;
	public static double slideValuePause;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		cbMusique.setSelected(ParametreController.cbMusiqueCoche);
		cbEffet.setSelected(ParametreController.cbSonCoche);
		sliderMusiquePause.setValue(ParametreController.slideValue);
	}

	@FXML
	public void reprendre(MouseEvent me) {
		InputStream fileSound1 = getClass().getResourceAsStream("/ihm/ressources/musique/BEEP1.wav");

		// Pour la musique

		if (fileMusique != null) {
			if (cbMusique.isSelected()) {
				System.out.println("\tLancement de la musique");

				if (Musique.clipTimePosition == 0 && MusiqueLancee == false && Musique.musiqueEnCours != true) { // si la musique n'a jamais été lancé
					Musique.playMusique(fileMusique);
					Musique.musiqueEnCours = true;
					MusiqueLancee = true;
				} else if (MusiqueLancee == false && Musique.musiqueEnCours != true) {
					Musique.resumeMusique(Musique.clip); // si elle a deja été lancé mais mis en pause, reprend a partir du point d'arret
					Musique.musiqueEnCours  = true;
				}

			} else if (MusiqueLancee == true) {
				Musique.pauseMusique(Musique.clip); // met en pause la musique
				Musique.musiqueEnCours = false;
				MusiqueLancee = false;
				System.out.println("\tMise en pause de la musique");
			}
		} else {
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
		ParametreController.slideValue = slideValuePause;

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

		/*
		 * final URL fxmlURL = getClass().getResource("/ihm/ressources/Menu.fxml");
		 * final ResourceBundle bundle =
		 * ResourceBundle.getBundle("domaine.properties.langue", Locale.FRENCH); final
		 * FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle); AnchorPane root =
		 * fxmlLoader.load();
		 */

		final URL fxmlURL = getClass().getResource("/ihm/ressources/Menu.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", Locale.FRENCH);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		AnchorPane root = fxmlLoader.load();

	}
	
	@FXML
	public void slideVolumeMusique(MouseEvent mouseEvent) throws IOException {

		if (Musique.musiqueEnCours == true) {
			System.out.println("slide");
			Musique.setVolume(sliderMusiquePause.getValue());
			slideValuePause = sliderMusiquePause.getValue();

		}else {
			System.out.println("probleme");
		}
	}

	/*
	@FXML
	public void monterVolume(MouseEvent mouseEvent) throws IOException {
		Musique.volumeUp(5.f);
		System.out.println("on monte le son");
	}

	@FXML
	public void baisserVolume(MouseEvent mouseEvent) throws IOException {
		Musique.volumeDown(5.f);
		System.out.println("on baisse le son");

	}
	*/


}

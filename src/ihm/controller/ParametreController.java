package ihm.controller;

import java.io.File;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ParametreController implements Initializable {
	@FXML
	private Pane rootPane;
	@FXML
	private CheckBox cmusique;
	@FXML
	private CheckBox cbEffetSonore;
	@FXML
	private CheckBox clair;
	@FXML
	private ComboBox<String> langues;
	boolean coche = false; // verifi si la checbox musical est coche
	boolean MusiqueLancee = false; //verifi si la musique a déja été lancé une première fois
	
	public EffetSonore soundEffects = new EffetSonore();

	String filepathMusique = "/ihm/ressources/musique/The_Red_Fox_Tavern.wav"; // lien vers la musique : https://www.youtube.com/watch?v=LBpKUIyOHdo
	InputStream fileMusique =  getClass().getResourceAsStream("/ihm/ressources/musique/The_Red_Fox_Tavern.wav");

	File repertoire = new File("src//ihm//ressources");
	File repertoire2;
	String liste[] = repertoire.list();
	
	/*
	public void ParametreController() {
		EffetSonore sound = soundEffects;
	}*/

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		langues.getItems().add("Anglais");
		langues.getItems().add("Allemand");
		langues.getItems().add("Espagnol");
		langues.getItems().add("Français");

	}

	@FXML
	public void enregistre(MouseEvent mouseEvent) throws IOException, Exception {

		//Pour la musique
		if (fileMusique!=null) {

			if (cmusique.isSelected() == true) {
				coche = true;
				if (Musique.clipTimePosition == 0 && MusiqueLancee == false) { // si la musique n'a jamais été lancé
					Musique.playMusique(fileMusique);
					MusiqueLancee = true;

				} else {
					Musique.resumeMusique(Musique.clip); // si elle a deja été lancé mais mis en pause, reprend a partir du point d'arret
				}

			} else {
				if (coche == true) {
					coche = false;
					Musique.pauseMusique(Musique.clip); //met en pause la musique 
				}

			}

		}
		
		//Pour les effets sonores
		if (cbEffetSonore.isSelected() == true) {
			soundEffects.setSoundOK(true);
			
			System.out.println(soundEffects.isSoundOK());
		}
		
		else {
			soundEffects.setSoundOK(false);
			System.out.println(soundEffects.isSoundOK());
		}
		

		// Pour la couleur du theme
		
				/*
				if (clair.isSelected()) {
					//Pane root = FXMLLoader.load(getClass().getResource("../ressources/parametre.fxml"));
					//root.setStyle("ressources/style/menuLight.css");

					if (liste != null) {
						for (int i = 0; i < liste.length; i++) {

							System.out.println(liste[i]);
							System.out.println(i);
							repertoire2 = new File("../ressources/" + liste[i]);

							if (repertoire.isDirectory() == false) {
								if (liste[i] == "Plateau.fxml") {
									Pane root1 = FXMLLoader.load(getClass().getResource("../ressources/" + liste[i]));
									root1.setStyle("../ressources/style/plateau.css");

								}
								Pane root1 = FXMLLoader.load(getClass().getResource("../ressources/" + liste[i]));
								root1.setStyle("../ressources/style/menuLight.css");
							}
						}

					}

				}*/

		soundEffects.playSoundEffect("src//ihm//ressources//musique//BEEP1.wav"); //emet un bruit sur le bouton si les effets sonores sont activés
		
		// Quitter les paramètres		
		final URL fxmlURL = getClass().getResource("/ihm/ressources/Menu.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", Locale.FRANCE);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		Pane pane = fxmlLoader.load();

        rootPane.getChildren().setAll(pane);
		
		

	}

	
	//getters and setters
	public EffetSonore getSoundEffects() {
		return soundEffects;
	}

	public void setSoundEffects(EffetSonore soundEffects) {
		this.soundEffects = soundEffects;
	}
	
	
	
	
	
}
